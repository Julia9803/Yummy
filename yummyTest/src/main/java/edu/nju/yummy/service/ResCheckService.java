package edu.nju.yummy.service;

import edu.nju.yummy.model.OrderForm;

import java.util.ArrayList;

public interface ResCheckService {
    ArrayList<OrderForm> checkResDeliverRecords(String rid);
    ArrayList<OrderForm> checkResOrderInfoByTime(String rid);
    ArrayList<OrderForm> checkResOrderInfoByMoney(String rid);
    ArrayList<OrderForm> checkResOrderInfoByUser(String rid);
    ArrayList<OrderForm> checkResCancelInfoByTime(String rid);
    ArrayList<OrderForm> checkResCancelInfoByMoney(String rid);
    ArrayList<OrderForm> checkResCancelInfoByUser(String rid);
    ArrayList<OrderForm> checkResFinanceInfoByTime(String rid);
    ArrayList<OrderForm> checkResFinanceInfoByMoney(String rid);
    ArrayList<OrderForm> checkResFinanceInfoByUser(String rid);

}
