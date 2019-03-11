package edu.nju.yummy.service;

import edu.nju.yummy.entity.Address;
import edu.nju.yummy.entity.ComboFood;
import edu.nju.yummy.entity.Food;
import edu.nju.yummy.entity.Restaurant;
import edu.nju.yummy.model.*;

import java.util.ArrayList;

public interface RestaurantService {
    Message register(Restaurant restaurant);
    Message update(String idCode,String phoneNumber,String name,String password,String type,Address address);
    Message updateAddress(Address address);
    Message login(String idCode, String password);
    Message publishSingle(String idCode, Food food);
    Message publishCombo(String idCode, ComboFood food);
    Restaurant findById(int id);
    Restaurant findByIdCode(String idCode);
    ArrayList<Address> findAddressByIdCode(String idCode);
    Restaurant findByPhoneNumber(String phoneNumber);
}
