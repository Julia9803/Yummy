package edu.nju.yummy.service;

import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.Order;

import java.util.Date;

public interface OrderService {
    Message orderMeal(Order order);
    Message cancelMeal(String orderId, Date date);
}
