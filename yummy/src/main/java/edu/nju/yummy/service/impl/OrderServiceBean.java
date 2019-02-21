package edu.nju.yummy.service.impl;

import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.Order;
import edu.nju.yummy.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceBean implements OrderService {
    @Override
    public Message orderMeal(Order order) {
        return null;
    }

    @Override
    public Message cancelMeal(String orderId, Date date) {
        return null;
    }
}
