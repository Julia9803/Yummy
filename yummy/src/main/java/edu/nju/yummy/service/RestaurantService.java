package edu.nju.yummy.service;

import edu.nju.yummy.model.Food;
import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.Restaurant;

public interface RestaurantService {
    Message register(Restaurant restaurant);
    Message changePhone(String phoneNumber);
    Message changeName(String name);
    Message changeAddress(String address);
    Message changeType(String type);
    Message changePassword(String password);
    Message login(String phoneNumber, String password);
    Message publishInfo(Food food);
}
