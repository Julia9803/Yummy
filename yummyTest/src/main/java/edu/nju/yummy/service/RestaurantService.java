package edu.nju.yummy.service;

import edu.nju.yummy.model.*;

public interface RestaurantService {
    Message register(Restaurant restaurant);
//    Message changePhone(int restaurantId, String phoneNumber);
//    Message changeName(int restaurantId, String name);
//    Message changeAddress(int restaurantId, Address address);
//    Message changeType(int restaurantId, String type);
//    Message changePassword(int restaurantId, String password);
    Message update(String idCode,String phoneNumber,String name,String password,String type);
    Message login(String idCode, String password);
    Message publishSingle(String idCode, Food food, int num);
    Message publishCombo(String idCode, ComboFood food, int num);
    Restaurant findById(int id);
    Restaurant findByIdCode(String idCode);
    Restaurant findByPhoneNumber(String phoneNumber);
}
