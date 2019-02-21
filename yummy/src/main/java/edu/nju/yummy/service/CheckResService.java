package edu.nju.yummy.service;

import edu.nju.yummy.model.Order;

import java.util.ArrayList;

public interface CheckResService {
    ArrayList<Order> checkResDeliverRecords(String rid);
    ArrayList<Order> checkResOrderInfoByTime(String rid);
    ArrayList<Order> checkResOrderInfoByMoney(String rid);
    ArrayList<Order> checkResOrderInfoByUser(String rid);
    ArrayList<Order> checkResCancelInfoByTime(String rid);
    ArrayList<Order> checkResCancelInfoByMoney(String rid);
    ArrayList<Order> checkResCancelInfoByUser(String rid);
    ArrayList<Order> checkResFinanceInfoByTime(String rid);
    ArrayList<Order> checkResFinanceInfoByMoney(String rid);
    ArrayList<Order> checkResFinanceInfoByUser(String rid);

}
