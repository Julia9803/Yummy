package edu.nju.yummy.service.impl;

import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.Order;
import edu.nju.yummy.service.BalanceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BalanceServiceBean implements BalanceService {
    @Override
    public ArrayList<Order> getBalanceOrders() {
        return null;
    }

    @Override
    public Message dealBalanceOrder(String oid) {
        return null;
    }
}