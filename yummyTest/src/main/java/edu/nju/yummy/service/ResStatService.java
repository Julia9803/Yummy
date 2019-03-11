package edu.nju.yummy.service;

import edu.nju.yummy.entity.OrderForm;
import edu.nju.yummy.model.HistoryOrderPresent;

import java.util.ArrayList;

public interface ResStatService {
    ArrayList<HistoryOrderPresent> checkResDeliverRecords(String idCode,String type);
    ArrayList<OrderForm> checkResOrderInfoByTime(String idCode);
    ArrayList<OrderForm> checkResOrderInfoByMoney(String idCode);
    ArrayList<OrderForm> checkResOrderInfoByUser(String idCode);
    ArrayList<OrderForm> checkResCancelInfoByTime(String idCode);
    ArrayList<OrderForm> checkResCancelInfoByMoney(String idCode);
    ArrayList<OrderForm> checkResCancelInfoByUser(String idCode);
    ArrayList<OrderForm> checkResFinanceInfoByTime(String idCode);
    ArrayList<OrderForm> checkResFinanceInfoByMoney(String idCode);
    ArrayList<OrderForm> checkResFinanceInfoByUser(String idCode);

}
