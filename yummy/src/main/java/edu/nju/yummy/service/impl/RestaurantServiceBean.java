package edu.nju.yummy.service.impl;

import edu.nju.yummy.model.Food;
import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.Restaurant;
import edu.nju.yummy.service.RestaurantService;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceBean implements RestaurantService {
    @Override
    public Message register(Restaurant restaurant) {
        return null;
    }

    @Override
    public Message changePhone(String phoneNumber) {
        return null;
    }

    @Override
    public Message changeName(String name) {
        return null;
    }

    @Override
    public Message changeAddress(String address) {
        return null;
    }

    @Override
    public Message changeType(String type) {
        return null;
    }

    @Override
    public Message changePassword(String password) {
        return null;
    }

    @Override
    public Message login(String phoneNumber, String password) {
        return null;
    }

    @Override
    public Message publishInfo(Food food) {
        return null;
    }
}
