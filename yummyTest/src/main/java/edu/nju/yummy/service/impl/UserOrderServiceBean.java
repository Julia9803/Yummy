package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.*;
import edu.nju.yummy.model.*;
import edu.nju.yummy.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserOrderServiceBean implements UserOrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BankRepository bankRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CompanyRepository companyRepository;

    @Value("${edu.nju.yummy.order_time}")
    private int orderTime;
    @Value("${edu.nju.yummy.cancel_time}")
    private int cancelTime;
    Timer timer = new Timer();

    /**
     * judge if restaurant stock is enough
     * if not enough return FAIL
     * if enough return SUCCESS
     * @param orderForm
     * @return
     */
    @Override
    synchronized public Message orderMeal(OrderForm orderForm) {
        // judge if stock enough
        Restaurant restaurant = restaurantRepository.findByRestaurantId(orderForm.getRestaurantId());
        ArrayList<Food> singleFoods = orderForm.getSingleFood();
        ArrayList<ComboFood> comboFoods = orderForm.getComboFood();
        if(singleFoods.size() != 0) {
            for (int i = 0; i < singleFoods.size(); i++) {
                if(restaurant.getSingleNum().get(i) <= orderForm.getSingleNum().get(i)) {
                    return Message.FAIL;
                }
                int num = restaurant.getSingleNum().get(i);
                restaurant.getSingleNum().set(i,num - orderForm.getSingleNum().get(i));
            }
        }

        if(comboFoods.size() != 0) {
            for (int i = 0; i < comboFoods.size(); i++) {
                if(restaurant.getComboNum().get(i) <= orderForm.getComboNum().get(i)) {
                    return Message.FAIL;
                }
                int num = restaurant.getComboNum().get(i);
                restaurant.getComboNum().set(i,num - orderForm.getComboNum().get(i));
            }
        }

        // calculate total money
        User user = userRepository.findByPhoneNumber(orderForm.getUserPhone());
        int grade = user.getGrade();
        orderForm.setTotalMoney(getDiscount(grade,orderForm.getOrderMoney()));

        //calculate income for company and res
        calIncome(orderForm.getTotalMoney(),restaurant);

        orderRepository.save(orderForm);
        orderClose(orderForm.getOrderId());
        return Message.SUCCESS;
    }

    /**
     * 退订规则：
     * 1. 下单十分钟内退订且未派送返还100%金额
     * 2. 下单十分钟内退订且已派送未收到返还50%金额
     * 3. 下单十分钟内且已收到不予退订
     * 4. 下单十分钟后不予退订
     * @param orderId
     * @return
     */
    @Override
    public HashMap<Message,Double> cancelMeal(int orderId) {
        HashMap<Message,Double> map = new HashMap<>();
        double refund = 0.00;
        OrderForm orderForm = orderRepository.findByOrderId(orderId);
        Date orderTime = orderForm.getTime();
        boolean res = judgeDate(orderTime,cancelTime);
        if(!res) {
            map.put(Message.OVERTIME,refund);
            return map;
        } else if(orderForm.isDelivered()) {
            map.put(Message.DELIVERED,refund);
            return map;
        } else if(orderForm.isDelivering()) {
            refund = Math.round(orderForm.getTotalMoney()/2*100)/100;
            map.put(Message.DELIVERING, refund);
            return map;
        } else if(!orderForm.isDelivering()) {
            refund = Math.round(orderForm.getTotalMoney()*100)/100;
            map.put(Message.SUCCESS,refund);
            return map;
        } else {
            map.put(Message.FAIL,refund);
            return map;
        }
    }

    @Override
    public Message payMeal(String bankAccount, String password, int orderId) {
        OrderForm form = orderRepository.findByOrderId(orderId);
        double orderMoney = form.getTotalMoney();
        String phoneNumber = form.getUserPhone();
        Bank bank = bankRepository.findByBankAccount(bankAccount);
        if(bank == null) {
            return Message.NOTFOUND;
        }
        double balance = bank.getBalance();

        if(bank.getPassword().equals(password)) {
            if(balance >= orderMoney) {
                bank.setBalance(Math.round((balance - orderMoney)*100)/100);
                upGrade(phoneNumber, orderMoney);
                return Message.SUCCESS;
            }
            return Message.BALANCELOW;
        }
        return Message.FAIL;
    }

    @Override
    public Message checkUserOrderState(int oid) {
        OrderForm form = orderRepository.findByOrderId(oid);
        if(form.isDelivering()) {
            return Message.DELIVERING;
        } else if(form.isDelivered()) {
            form.setEnsureDelivered(true);
            form.setDelivering(false);
            orderRepository.save(form);
            return Message.DELIVERED;
        } else if(!form.isPayed()) {
            return Message.NOTPAID;
        } else if(form.isCancelled()) {
            return Message.CANCELLED;
        }
        return Message.FAIL;
    }

    private boolean judgeDate(Date date1,int minute) {
        Date date2 = new Date();
        int standard = minute*60*1000;
        int tmp = (int) (date1.getTime() - date2.getTime());
        return tmp <= standard;
    }

    private void orderClose(int orderId) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                OrderForm form = orderRepository.findByOrderId(orderId);
                if(!form.isCancelled() && !form.isPayed() && judgeDate(form.getTime(),orderTime)) {
                    form.setCancelled(true);
                }
                timer.cancel();
            }
        },2*60*60*1000);
    }

    /**
     * 升级策略(Lv 1-5)
     * @param phoneNumber
     * @param orderMoney
     */
    private void upGrade(String phoneNumber, double orderMoney) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        user.setTotalSpend(user.getTotalSpend()+orderMoney);
        double totalSpend = user.getTotalSpend();
        if(totalSpend >= 10000.00) {
            user.setGrade(5);
        } else if(totalSpend >= 5000.00) {
            user.setGrade(4);
        } else if(totalSpend >= 1000.00) {
            user.setGrade(3);
        } else if(totalSpend >= 500.00) {
            user.setGrade(2);
        } else if(totalSpend >= 100.00) {
            user.setGrade(1);
        } else {
            user.setGrade(0);
        }
    }

    private double getDiscount(int grade,double totalMoney) {
        double discountRate = 1.00;
        switch (grade) {
            case 1:
                discountRate = 0.95;
                break;
            case 2:
                discountRate = 0.90;
                break;
            case 3:
                discountRate = 0.85;
                break;
            case 4:
                discountRate = 0.80;
                break;
            case 5:
                discountRate = 0.75;
                break;
        }
        return totalMoney*discountRate;
    }

    /**
     * 订餐结算规则：
     * 用户支付金额90% 给res 10%给company
     * @param totalMoney
     * @param restaurant
     */
    private void calIncome(double totalMoney, Restaurant restaurant) {
        double resIncome = totalMoney*0.9;
        double companyIncome = totalMoney*0.1;
        restaurant.setIncome(restaurant.getIncome() + resIncome);
        restaurantRepository.save(restaurant);
        Company company = new Company();
        company.setIncome(companyIncome);
        Calendar calendar = Calendar.getInstance();
        company.setMonth(calendar.get(Calendar.YEAR) + " " + calendar.get(Calendar.MONTH));
        companyRepository.save(company);
    }
}
