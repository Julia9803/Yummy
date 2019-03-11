package edu.nju.yummy.service;
import edu.nju.yummy.entity.OrderForm;
import edu.nju.yummy.model.HistoryOrderPresent;

import java.util.ArrayList;

public interface UserStatService {
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
