package edu.nju.yummy.service.impl;

import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.Order;
import edu.nju.yummy.service.CheckUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CheckUserServiceBean implements CheckUserService {

    @Override
    public String checkUserOrderState(String oid) {
        return null;
    }

    @Override
    public ArrayList<Order> checkUserOrderInfoByTime(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<Order> checkUserOrderInfoByMoney(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<Order> checkUserOrderInfoByRestaurant(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<Order> checkUserCancelMealInfoByTime(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<Order> checkUserCancelMealInfoByMoney(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<Order> checkUserCancelMealInfoByRestaurant(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<Order> checkUserSpendInfoByTime(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<Order> checkUserSpendInfoByMoney(String phoneNumber) {
        return null;
    }

    @Override
    public ArrayList<Order> checkUserSpendInfoByRestaurant(String phoneNumber) {
        return null;
    }
}
