package edu.nju.yummy.service.impl;

import edu.nju.yummy.model.OrderForm;
import edu.nju.yummy.service.ResCheckService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ResCheckServiceBean implements ResCheckService {
    @Override
    public ArrayList<OrderForm> checkResDeliverRecords(String rid) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkResOrderInfoByTime(String rid) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkResOrderInfoByMoney(String rid) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkResOrderInfoByUser(String rid) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkResCancelInfoByTime(String rid) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkResCancelInfoByMoney(String rid) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkResCancelInfoByUser(String rid) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkResFinanceInfoByTime(String rid) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkResFinanceInfoByMoney(String rid) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkResFinanceInfoByUser(String rid) {
        return null;
    }
}
