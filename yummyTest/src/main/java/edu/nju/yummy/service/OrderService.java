package edu.nju.yummy.service;

import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.OrderForm;

import java.util.Date;

public interface OrderService {
    Message orderMeal(OrderForm orderForm);
    Message cancelMeal(String orderId, Date date);
}
