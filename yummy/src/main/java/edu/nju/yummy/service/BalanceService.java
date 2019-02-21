package edu.nju.yummy.service;

import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.Order;

import java.util.ArrayList;

public interface BalanceService {

    ArrayList<Order> getBalanceOrders();
    Message dealBalanceOrder(String oid);
}
