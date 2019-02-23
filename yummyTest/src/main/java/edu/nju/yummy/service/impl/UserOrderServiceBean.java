package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.BankRepository;
import edu.nju.yummy.dao.OrderRepository;
import edu.nju.yummy.dao.RestaurantRepository;
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
    @Value("${edu.nju.yummy.order_time}")
    private int orderTime;
    @Value("${edu.nju.yummy.cancel_time}")
    private int cancelTime;
    Timer timer = new Timer();

    /**
     * judge if restaurant stock is enough
     * if not enough return FAIL
     * if enogh return SUCCESS
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
        Bank bank = bankRepository.findByBankAccount(bankAccount);
        if(bank == null) {
            return Message.NOTFOUND;
        }
        double balance = bank.getBalance();

        if(bank.getPassword().equals(password)) {
            if(balance >= orderMoney) {
                bank.setBalance(Math.round((balance - orderMoney)*100)/100);
                return Message.SUCCESS;
            }
            return Message.BALANCELOW;
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
}
