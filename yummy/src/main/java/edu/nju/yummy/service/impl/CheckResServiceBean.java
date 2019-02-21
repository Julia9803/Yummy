package edu.nju.yummy.service.impl;

import edu.nju.yummy.model.Order;
import edu.nju.yummy.service.CheckResService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CheckResServiceBean implements CheckResService {
    @Override
    public ArrayList<Order> checkResDeliverRecords(String rid) {
        return null;
    }

    @Override
    public ArrayList<Order> checkResOrderInfoByTime(String rid) {
        return null;
    }

    @Override
    public ArrayList<Order> checkResOrderInfoByMoney(String rid) {
        return null;
    }

    @Override
    public ArrayList<Order> checkResOrderInfoByUser(String rid) {
        return null;
    }

    @Override
    public ArrayList<Order> checkResCancelInfoByTime(String rid) {
        return null;
    }

    @Override
    public ArrayList<Order> checkResCancelInfoByMoney(String rid) {
        return null;
    }

    @Override
    public ArrayList<Order> checkResCancelInfoByUser(String rid) {
        return null;
    }

    @Override
    public ArrayList<Order> checkResFinanceInfoByTime(String rid) {
        return null;
    }

    @Override
    public ArrayList<Order> checkResFinanceInfoByMoney(String rid) {
        return null;
    }

    @Override
    public ArrayList<Order> checkResFinanceInfoByUser(String rid) {
        return null;
    }
}
