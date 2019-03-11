package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.*;
import edu.nju.yummy.entity.*;
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
    @Autowired
    OrderFoodRepository orderFoodRepository;
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    ComboFoodRepository comboFoodRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserStatServiceBean userStatServiceBean;

    @Value("${edu.nju.yummy.order_time}")
    private int orderTime;
    @Value("${edu.nju.yummy.cancel_time}")
    private int cancelTime;

    @Override
    public ArrayList<RestaurantPresent> getResPresent(String userEmail) {
        ArrayList<Restaurant> restaurants = restaurantRepository.findAll();
        ArrayList<RestaurantPresent> presents = new ArrayList<>();
        String idCode = null;
        String resName = null;

        for(Restaurant restaurant:restaurants) {
            if(judgeDeliverable(userEmail,restaurant.getIdCode())) {
                idCode = restaurant.getIdCode();
                resName = restaurant.getName();
                ArrayList<Food> foods = foodRepository.findByRestaurantIdCode(idCode);

                ArrayList<Integer> foodIds = new ArrayList<>();
                ArrayList<String> foodNames = new ArrayList<>();
                ArrayList<Integer> foodNums = new ArrayList<>();
                ArrayList<String> foodTypes = new ArrayList<>();
                ArrayList<Double> foodPrices = new ArrayList<>();
                for (Food food : foods) {
                    if (judgeDateValid(food.getStartTime(), food.getEndTime())) {
                        foodIds.add(food.getFoodId());
                        foodNames.add(food.getName());
                        foodNums.add(food.getNum());
                        foodTypes.add(food.getType());
                        foodPrices.add(food.getPrice());
                    }
                }

                ArrayList<ComboFood> comboFoods = comboFoodRepository.findByRestaurantIdCode(idCode);
                ArrayList<Integer> comboFoodIds = new ArrayList<>();
                ArrayList<String> comboFoodNames = new ArrayList<>();
                ArrayList<Integer> comboFoodNums = new ArrayList<>();
                ArrayList<Double> comboFoodPrices = new ArrayList<>();
                for (ComboFood comboFood : comboFoods) {
                    if (judgeDateValid(comboFood.getStartTime(), comboFood.getEndTime())) {
                        comboFoodIds.add(comboFood.getComboId());
                        comboFoodNames.add(comboFood.getName());
                        comboFoodNums.add(comboFood.getNum());
                        comboFoodPrices.add(comboFood.getPrice());
                    }
                }


                RestaurantPresent present = new RestaurantPresent(idCode, resName, foodNames, foodIds, foodNums, foodTypes, foodPrices, comboFoodNames, comboFoodIds, comboFoodNums, comboFoodPrices);
                presents.add(present);
            }
        }
        return presents;
    }

    /**
     * 根据餐厅与用户地理位置距离判断是否在可配送范围内
     * @param email
     * @param idCode
     * @return
     */
    private boolean judgeDeliverable(String email,String idCode) {
        Address userAddress = addressRepository.findByCodeAndChosenTrue(email);
        Address resAddress = addressRepository.findByCode(idCode).get(0);
        if(userAddress.getProvince().equals(resAddress.getProvince())) {
            if(userAddress.getCity().equals(resAddress.getCity())) {
                return true;
            }
        }
        return false;
    }

    private boolean judgeDateValid(Date startTime, Date endTime) {
        Date date = new Date();
        return date.getTime() > startTime.getTime() && date.getTime() < endTime.getTime();
    }

    /**
     * judge if restaurant stock is enough
     * if not enough return FAIL
     * if enough return SUCCESS
     * @param orderForm
     * @return
     */
    @Override
    synchronized public Message orderMeal(OrderForm orderForm, ArrayList<BagContent> contents) {
        // judge if stock enough
        Restaurant restaurant = restaurantRepository.findByIdCode(orderForm.getRestaurantIdCode());

        OrderForm form = orderRepository.save(orderForm);
        // add OrderFood
        for(BagContent content:contents) {
            OrderFood orderFood = new OrderFood();
            orderFood.setFoodId(content.getFoodId());
            orderFood.setName(content.getName());
            orderFood.setOid(form.getOrderId());
            orderFood.setOrderNum(content.getOrderNum());
            orderFood.setPrice(content.getPrice());
            orderFood.setType(content.getType());
            orderFoodRepository.save(orderFood);
        }

        ArrayList<OrderFood> foods = orderFoodRepository.findByOid(orderForm.getOrderId());

        if(foods.size() > 0) {
            for (OrderFood food1 : foods) {
                int orderNum = food1.getOrderNum();

                Food food = foodRepository.findByFoodId(food1.getFoodId());
                if(food != null) {
                    int resNum = food.getNum();
                    if (resNum < orderNum)
                        return Message.FAIL;
                    food.setNum(resNum - orderNum);
                    foodRepository.save(food);
                }

                ComboFood comboFood = comboFoodRepository.findByComboId(food1.getFoodId());
                if(comboFood != null) {
                    int resNum = comboFood.getNum();
                    if (resNum < orderNum)
                        return Message.FAIL;
                    comboFood.setNum(resNum - orderNum);
                    comboFoodRepository.save(comboFood);
                }
            }
        }

        // calculate income for company and res
        calIncome(orderForm.getTotalMoney(),restaurant);

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
    public HashMap<Message,Double> cancelMeal(int orderId,String bankAccount) {
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
            bankRefund(refund, bankAccount);
            orderForm.setCancelled(true);
            orderRepository.save(orderForm);
            map.put(Message.DELIVERING, refund);
            return map;
        } else if(!orderForm.isDelivering()) {
            refund = Math.round(orderForm.getTotalMoney()*100)/100;
            bankRefund(refund, bankAccount);
            orderForm.setCancelled(true);
            orderRepository.save(orderForm);
            map.put(Message.SUCCESS,refund);
            return map;
        } else {
            map.put(Message.FAIL,refund);
            return map;
        }
    }

    private void bankRefund(double refund, String bankAccount) {
        Bank bank = bankRepository.findByBankAccount(bankAccount);
        bank.setBalance(bank.getBalance() + refund);
        bankRepository.save(bank);
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
                bankRepository.save(bank);
                form.setPayed(true);
                orderRepository.save(form);
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

    @Override
    public ArrayList<HistoryOrderPresent> checkUserOrderInfo(String phoneNumber,String type) {
        ArrayList<OrderForm> forms = null;
        if(type == null)
            forms = orderRepository.findByUserPhone(phoneNumber);
        else {
            switch (type) {
                case "1":
                    forms = userStatServiceBean.checkUserOrderInfoByTime(phoneNumber);
                    break;
                case "2":
                    forms = userStatServiceBean.checkUserOrderInfoByMoney(phoneNumber);
                    break;
                case "3":
                    forms = userStatServiceBean.checkUserOrderInfoByRestaurant(phoneNumber);
                    break;
                case "4":
                    forms = userStatServiceBean.checkUserCancelMealInfoByTime(phoneNumber);
                    break;
                case "5":
                    forms = userStatServiceBean.checkUserCancelMealInfoByMoney(phoneNumber);
                    break;
                case "6":
                    forms = userStatServiceBean.checkUserCancelMealInfoByRestaurant(phoneNumber);
                    break;
                case "7":
                    forms = userStatServiceBean.checkUserSpendInfoByTime(phoneNumber);
                    break;
                case "8":
                    forms = userStatServiceBean.checkUserSpendInfoByMoney(phoneNumber);
                    break;
                case "9":
                    forms = userStatServiceBean.checkUserSpendInfoByRestaurant(phoneNumber);
                    break;
                default:
                    forms = orderRepository.findByUserPhone(phoneNumber);
            }
        }

        ArrayList<HistoryOrderPresent> presents = new ArrayList<>();

        for(OrderForm form:forms) {
            HistoryOrderPresent present = new HistoryOrderPresent();
            ArrayList<OrderFood> food = orderFoodRepository.findByOid(form.getOrderId());
            if(form.isDelivered()) {
                present.setDeliverState("已送达");
            } else if(form.isDelivering()) {
                present.setDeliverState("配送中");
            } else if((!form.isDelivering()) && (!form.isDelivered())) {
                present.setDeliverState("未配送");
            }
            present.setEnsureDelivered(form.isEnsureDelivered());
            present.setFoods(food);
            present.setOrderId(form.getOrderId());
            present.setCancelled(form.isCancelled());
            present.setOrderMoney(form.getOrderMoney());
            present.setPayed(form.isPayed());
            present.setTime(form.getTime());
            present.setTotalMoney(form.getTotalMoney());
            present.setRestaurantIdCode(form.getRestaurantIdCode());
            present.setUserPhone(form.getUserPhone());
            present.setUserAddress(addressRepository.findById(form.getUserAddressId()));

            if(!form.isPayed() && !judgeDate(form.getTime(),orderTime)) {
                present.setCancelled(true);
                form.setCancelled(true);
                orderRepository.save(form);
            }
            presents.add(present);
        }

        return presents;
    }

    private boolean judgeDate(Date date1,int minute) {
        Date date2 = new Date();
        int standard = minute*60*1000;
        int tmp = (int) (date2.getTime() - date1.getTime());
        return tmp < standard;
    }

    private void orderClose(int orderId) {
        System.out.println("count time");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                OrderForm form = orderRepository.findByOrderId(orderId);
                if((!form.isCancelled()) && (!form.isPayed()) && (!judgeDate(form.getTime(),orderTime))) {
                    form.setCancelled(true);
                    orderRepository.save(form);
                    System.out.println("order cancelled");
                }
                System.out.println("mission over");
                timer.cancel();
            }
        },2*60*1000);
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
        userRepository.save(user);
    }

    /**
     * 根据用户级别进行打折优惠
     * @param grade
     * @param orderMoney
     * @return
     */
    @Override
    public double getDiscount(int grade,double orderMoney) {
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
        return orderMoney - orderMoney*discountRate;
    }

    /**
     * 计算订单原价
     * @param contents
     * @return
     */
    @Override
    public double calOrderMoney(ArrayList<BagContent> contents) {
        double orderMoney = 0;
        for(BagContent content:contents) {
            orderMoney += content.getPrice()*content.getOrderNum();
        }
        return orderMoney;
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
        company.setRidCode(restaurant.getIdCode());
        Calendar calendar = Calendar.getInstance();
        company.setMonth(calendar.get(Calendar.YEAR) + " " + calendar.get(Calendar.MONTH));
        companyRepository.save(company);
    }
}
