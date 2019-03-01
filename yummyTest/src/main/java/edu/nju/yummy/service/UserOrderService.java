package edu.nju.yummy.service;

import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.OrderForm;

import java.util.Date;
import java.util.HashMap;

public interface UserOrderService {
    Message orderMeal(OrderForm orderForm);
    HashMap<Message,Double> cancelMeal(int orderId);
    Message payMeal(String bankAccount, String password, int orderId);
    Message checkUserOrderState(int oid);
}
