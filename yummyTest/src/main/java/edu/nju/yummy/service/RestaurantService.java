package edu.nju.yummy.service;

import edu.nju.yummy.model.*;

public interface RestaurantService {
    Message register(Restaurant restaurant);
    Message changePhone(int restaurantId, String phoneNumber);
    Message changeName(int restaurantId, String name);
    Message changeAddress(int restaurantId, String address);
    Message changeType(int restaurantId, String type);
    Message changePassword(int restaurantId, String password);
    Message login(int restaurantId, String password);
    Message publishSingle(int restaurantId, SingleFoodPack pack);
    Message publishCombo(int restaurantId, ComboFoodPack pack);
    Restaurant findById(int id);
    Restaurant findByPhoneNumber(String phoneNumber);
}
