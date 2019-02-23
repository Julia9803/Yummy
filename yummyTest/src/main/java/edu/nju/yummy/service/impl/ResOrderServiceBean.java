package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.OrderRepository;
import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.OrderForm;
import edu.nju.yummy.service.ResOrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class ResOrderServiceBean implements ResOrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Message startDeliver(int oid) {
        OrderForm form = orderRepository.findByOrderId(oid);
        form.setDelivering(true);
        orderRepository.save(form);
        return Message.SUCCESS;
    }

    @Override
    public Message delivered(int oid) {
        OrderForm form = orderRepository.findByOrderId(oid);
        form.setDelivered(true);
        return Message.SUCCESS;
    }
}
