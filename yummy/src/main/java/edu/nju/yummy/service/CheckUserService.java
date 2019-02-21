package edu.nju.yummy.service;
import edu.nju.yummy.model.Order;

import java.util.ArrayList;

public interface CheckUserService {
    String checkUserOrderState(String oid);
    ArrayList<Order> checkUserOrderInfoByTime(String phoneNumber);
    ArrayList<Order> checkUserOrderInfoByMoney(String phoneNumber);
    ArrayList<Order> checkUserOrderInfoByRestaurant(String phoneNumber);
    ArrayList<Order> checkUserCancelMealInfoByTime(String phoneNumber);
    ArrayList<Order> checkUserCancelMealInfoByMoney(String phoneNumber);
    ArrayList<Order> checkUserCancelMealInfoByRestaurant(String phoneNumber);
    ArrayList<Order> checkUserSpendInfoByTime(String phoneNumber);
    ArrayList<Order> checkUserSpendInfoByMoney(String phoneNumber);
    ArrayList<Order> checkUserSpendInfoByRestaurant(String phoneNumber);
}
