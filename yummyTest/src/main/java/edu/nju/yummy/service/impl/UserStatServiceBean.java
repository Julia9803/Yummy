package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.AddressRepository;
import edu.nju.yummy.dao.OrderFoodRepository;
import edu.nju.yummy.dao.OrderRepository;
import edu.nju.yummy.entity.OrderFood;
import edu.nju.yummy.entity.OrderForm;
import edu.nju.yummy.model.HistoryOrderPresent;
import edu.nju.yummy.service.UserStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserStatServiceBean implements UserStatService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderFoodRepository orderFoodRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public ArrayList<OrderForm> checkUserOrderInfoByTime(String phoneNumber) {
        return orderRepository.findByUserPhoneOrderByTimeDesc(phoneNumber);
    }

    @Override
    public ArrayList<OrderForm> checkUserOrderInfoByMoney(String phoneNumber) {
        return orderRepository.findByUserPhoneOrderByTotalMoneyDesc(phoneNumber);
    }

    @Override
    public ArrayList<OrderForm> checkUserOrderInfoByRestaurant(String phoneNumber) {
        return orderRepository.findByUserPhoneOrderByRestaurantIdCode(phoneNumber);
    }

    @Override
    public ArrayList<OrderForm> checkUserCancelMealInfoByTime(String phoneNumber) {
        return orderRepository.findByUserPhoneAndCancelledTrueOrderByTimeDesc(phoneNumber);
    }

    @Override
    public ArrayList<OrderForm> checkUserCancelMealInfoByMoney(String phoneNumber) {
        return orderRepository.findByUserPhoneAndCancelledTrueOrderByTotalMoneyDesc(phoneNumber);
    }

    @Override
    public ArrayList<OrderForm> checkUserCancelMealInfoByRestaurant(String phoneNumber) {
        return orderRepository.findByUserPhoneAndCancelledTrueOrderByRestaurantIdCodeDesc(phoneNumber);
    }

    @Override
    public ArrayList<OrderForm> checkUserSpendInfoByTime(String phoneNumber) {
        return orderRepository.findByUserPhoneAndPayedTrueOrderByTimeDesc(phoneNumber);
    }

    @Override
    public ArrayList<OrderForm> checkUserSpendInfoByMoney(String phoneNumber) {
        return orderRepository.findByUserPhoneAndPayedTrueOrderByTotalMoneyDesc(phoneNumber);
    }

    @Override
    public ArrayList<OrderForm> checkUserSpendInfoByRestaurant(String phoneNumber) {
        return orderRepository.findByUserPhoneAndPayedTrueOrderByRestaurantIdCode(phoneNumber);
    }
}
