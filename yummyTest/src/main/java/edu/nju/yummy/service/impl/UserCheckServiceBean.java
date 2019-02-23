package edu.nju.yummy.service.impl;

import edu.nju.yummy.model.OrderForm;
import edu.nju.yummy.service.UserCheckService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserCheckServiceBean implements UserCheckService {

    @Override
    public String checkUserOrderState(String oid) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkUserOrderInfoByTime(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkUserOrderInfoByMoney(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkUserOrderInfoByRestaurant(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkUserCancelMealInfoByTime(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkUserCancelMealInfoByMoney(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkUserCancelMealInfoByRestaurant(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkUserSpendInfoByTime(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkUserSpendInfoByMoney(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<OrderForm> checkUserSpendInfoByRestaurant(String phoneNumber) {
        return null;
    }
}
