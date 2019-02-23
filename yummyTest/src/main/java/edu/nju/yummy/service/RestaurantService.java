package edu.nju.yummy.service;

import edu.nju.yummy.model.*;

public interface RestaurantService {
    Message register(Restaurant restaurant);
//    Message changePhone(int restaurantId, String phoneNumber);
//    Message changeName(int restaurantId, String name);
//    Message changeAddress(int restaurantId, Address address);
//    Message changeType(int restaurantId, String type);
//    Message changePassword(int restaurantId, String password);
    Message update( int restaurantId, String phoneNumber,String name,Address address,String password,String type);
    Message login(int restaurantId, String password);
    Message publishSingle(int restaurantId, Food food);
    Message publishCombo(int restaurantId, ComboFood food);
    Restaurant findById(int id);
    Restaurant findByPhoneNumber(String phoneNumber);
}
