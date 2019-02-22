package edu.nju.yummy.service;

import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.OrderForm;

import java.util.ArrayList;

public interface BalanceService {

    ArrayList<OrderForm> getBalanceOrders();
    Message dealBalanceOrder(String oid);
}
