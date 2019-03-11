package edu.nju.yummy.service;

import edu.nju.yummy.model.BagContent;
import edu.nju.yummy.model.HistoryOrderPresent;
import edu.nju.yummy.model.Message;
import edu.nju.yummy.entity.OrderForm;
import edu.nju.yummy.model.RestaurantPresent;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserOrderService {
    ArrayList<HistoryOrderPresent> checkUserOrderInfo(String phoneNumber,String type);
    ArrayList<RestaurantPresent> getResPresent(String userEmail);
    Message orderMeal(OrderForm orderForm, ArrayList<BagContent> contents);
    HashMap<Message,Double> cancelMeal(int orderId,String bankAccount);
    Message payMeal(String bankAccount, String password, int orderId);
    Message checkUserOrderState(int oid);
    double getDiscount(int grade,double orderMoney);
    double calOrderMoney(ArrayList<BagContent> contents);
}
