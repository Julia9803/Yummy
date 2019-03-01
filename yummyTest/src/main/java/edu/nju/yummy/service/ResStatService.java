package edu.nju.yummy.service;

import edu.nju.yummy.model.OrderForm;

import java.util.ArrayList;

public interface ResStatService {
    ArrayList<OrderForm> checkResDeliverRecords(int rid);
    ArrayList<OrderForm> checkResOrderInfoByTime(int rid);
    ArrayList<OrderForm> checkResOrderInfoByMoney(int rid);
    ArrayList<OrderForm> checkResOrderInfoByUser(int rid);
    ArrayList<OrderForm> checkResCancelInfoByTime(int rid);
    ArrayList<OrderForm> checkResCancelInfoByMoney(int rid);
    ArrayList<OrderForm> checkResCancelInfoByUser(int rid);
    ArrayList<OrderForm> checkResFinanceInfoByTime(int rid);
    ArrayList<OrderForm> checkResFinanceInfoByMoney(int rid);
    ArrayList<OrderForm> checkResFinanceInfoByUser(int rid);

}
