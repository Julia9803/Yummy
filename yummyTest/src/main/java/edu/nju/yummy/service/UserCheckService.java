package edu.nju.yummy.service;
import edu.nju.yummy.model.OrderForm;

import java.util.ArrayList;

public interface UserCheckService {
    String checkUserOrderState(String oid);
    ArrayList<OrderForm> checkUserOrderInfoByTime(String phoneNumber);
    ArrayList<OrderForm> checkUserOrderInfoByMoney(String phoneNumber);
    ArrayList<OrderForm> checkUserOrderInfoByRestaurant(String phoneNumber);
    ArrayList<OrderForm> checkUserCancelMealInfoByTime(String phoneNumber);
    ArrayList<OrderForm> checkUserCancelMealInfoByMoney(String phoneNumber);
    ArrayList<OrderForm> checkUserCancelMealInfoByRestaurant(String phoneNumber);
    ArrayList<OrderForm> checkUserSpendInfoByTime(String phoneNumber);
    ArrayList<OrderForm> checkUserSpendInfoByMoney(String phoneNumber);
    ArrayList<OrderForm> checkUserSpendInfoByRestaurant(String phoneNumber);
}
