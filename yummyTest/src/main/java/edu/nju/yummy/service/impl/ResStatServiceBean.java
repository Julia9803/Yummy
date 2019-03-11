package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.AddressRepository;
import edu.nju.yummy.dao.OrderFoodRepository;
import edu.nju.yummy.dao.OrderRepository;
import edu.nju.yummy.entity.OrderFood;
import edu.nju.yummy.entity.OrderForm;
import edu.nju.yummy.model.HistoryOrderPresent;
import edu.nju.yummy.service.ResStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ResStatServiceBean implements ResStatService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderFoodRepository orderFoodRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public ArrayList<HistoryOrderPresent> checkResDeliverRecords(String idCode,String type) {
        ArrayList<OrderForm> forms = null;
        if(type == null)
            forms = orderRepository.findByRestaurantIdCode(idCode);
        else {
            switch (type) {
                case "1":
                    forms = checkResOrderInfoByTime(idCode);
                    break;
                case "2":
                    forms = checkResOrderInfoByMoney(idCode);
                    break;
                case "3":
                    forms = checkResOrderInfoByUser(idCode);
                    break;
                case "4":
                    forms = checkResCancelInfoByTime(idCode);
                    break;
                case "5":
                    forms = checkResCancelInfoByMoney(idCode);
                    break;
                case "6":
                    forms = checkResCancelInfoByUser(idCode);
                    break;
                case "7":
                    forms = checkResFinanceInfoByTime(idCode);
                    break;
                case "8":
                    forms = checkResFinanceInfoByMoney(idCode);
                    break;
                case "9":
                    forms = checkResFinanceInfoByUser(idCode);
                    break;
                default:
                    forms = orderRepository.findByRestaurantIdCode(idCode);
            }
        }

        ArrayList<HistoryOrderPresent> presents = new ArrayList<>();

        for(OrderForm form:forms) {
            HistoryOrderPresent present = new HistoryOrderPresent();
            ArrayList<OrderFood> food = orderFoodRepository.findByOid(form.getOrderId());
            if(form.isDelivered()) {
                present.setDeliverState("已送达");
            } else if(form.isDelivering()) {
                present.setDeliverState("配送中");
            } else if((!form.isDelivering()) && (!form.isDelivered())) {
                present.setDeliverState("未配送");
            }
            present.setEnsureDelivered(form.isEnsureDelivered());
            present.setFoods(food);
            present.setOrderId(form.getOrderId());
            present.setCancelled(form.isCancelled());
            present.setOrderMoney(form.getOrderMoney());
            present.setPayed(form.isPayed());
            present.setTime(form.getTime());
            present.setTotalMoney(form.getTotalMoney());
            present.setRestaurantIdCode(form.getRestaurantIdCode());
            present.setUserPhone(form.getUserPhone());
            present.setUserAddress(addressRepository.findById(form.getUserAddressId()));

            presents.add(present);
        }

        return presents;
    }

    @Override
    public ArrayList<OrderForm> checkResOrderInfoByTime(String idCode) {
        return orderRepository.findByRestaurantIdCodeOrderByTimeDesc(idCode);
    }

    @Override
    public ArrayList<OrderForm> checkResOrderInfoByMoney(String idCode) {
        return orderRepository.findByRestaurantIdCodeOrderByTotalMoneyDesc(idCode);
    }

    @Override
    public ArrayList<OrderForm> checkResOrderInfoByUser(String idCode) {
        return orderRepository.findByRestaurantIdCodeOrderByUserPhone(idCode);
    }

    @Override
    public ArrayList<OrderForm> checkResCancelInfoByTime(String idCode) {
        return orderRepository.findByRestaurantIdCodeAndCancelledTrueOrderByTimeDesc(idCode);
    }

    @Override
    public ArrayList<OrderForm> checkResCancelInfoByMoney(String idCode) {
        return orderRepository.findByRestaurantIdCodeAndCancelledTrueOrderByTotalMoneyDesc(idCode);
    }

    @Override
    public ArrayList<OrderForm> checkResCancelInfoByUser(String idCode) {
        return orderRepository.findByRestaurantIdCodeAndCancelledTrueOrderByUserPhone(idCode);
    }

    @Override
    public ArrayList<OrderForm> checkResFinanceInfoByTime(String idCode) {
        return orderRepository.findByRestaurantIdCodeAndPayedTrueOrderByTimeDesc(idCode);
    }

    @Override
    public ArrayList<OrderForm> checkResFinanceInfoByMoney(String idCode) {
        return orderRepository.findByRestaurantIdCodeAndPayedTrueOrderByTotalMoneyDesc(idCode);
    }

    @Override
    public ArrayList<OrderForm> checkResFinanceInfoByUser(String idCode) {
        return orderRepository.findByRestaurantIdCodeAndPayedTrueOrderByUserPhone(idCode);
    }
}
