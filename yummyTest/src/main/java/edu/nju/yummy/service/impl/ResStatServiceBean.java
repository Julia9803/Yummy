package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.OrderRepository;
import edu.nju.yummy.model.OrderForm;
import edu.nju.yummy.service.ResStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ResStatServiceBean implements ResStatService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public ArrayList<OrderForm> checkResDeliverRecords(int rid) {
        return orderRepository.findByRestaurantIdAndDeliveringTrueOrDeliveredTrueOrderByTimeDesc(rid);
    }

    @Override
    public ArrayList<OrderForm> checkResOrderInfoByTime(int rid) {
        return orderRepository.findByRestaurantIdOrderByTimeDesc(rid);
    }

    @Override
    public ArrayList<OrderForm> checkResOrderInfoByMoney(int rid) {
        return orderRepository.findByRestaurantIdOrderByTotalMoneyDesc(rid);
    }

    @Override
    public ArrayList<OrderForm> checkResOrderInfoByUser(int rid) {
        return orderRepository.findByRestaurantIdOrderByUserPhone(rid);
    }

    @Override
    public ArrayList<OrderForm> checkResCancelInfoByTime(int rid) {
        return orderRepository.findByRestaurantIdAndCancelledTrueOrderByTimeDesc(rid);
    }

    @Override
    public ArrayList<OrderForm> checkResCancelInfoByMoney(int rid) {
        return orderRepository.findByRestaurantIdAndCancelledTrueOrderByTotalMoneyDesc(rid);
    }

    @Override
    public ArrayList<OrderForm> checkResCancelInfoByUser(int rid) {
        return orderRepository.findByRestaurantIdAndCancelledTrueOrderByUserPhone(rid);
    }

    @Override
    public ArrayList<OrderForm> checkResFinanceInfoByTime(int rid) {
        return orderRepository.findByRestaurantIdAndPayedTrueOrderByTimeDesc(rid);
    }

    @Override
    public ArrayList<OrderForm> checkResFinanceInfoByMoney(int rid) {
        return orderRepository.findByRestaurantIdAndPayedTrueOrderByTotalMoneyDesc(rid);
    }

    @Override
    public ArrayList<OrderForm> checkResFinanceInfoByUser(int rid) {
        return orderRepository.findByRestaurantIdAndPayedTrueOrderByUserPhone(rid);
    }
}
