package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.*;
import edu.nju.yummy.entity.Address;
import edu.nju.yummy.entity.ComboFood;
import edu.nju.yummy.entity.Food;
import edu.nju.yummy.entity.Restaurant;
import edu.nju.yummy.model.*;
import edu.nju.yummy.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RestaurantServiceBean implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    ComboFoodRepository comboFoodRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Message register(Restaurant restaurant) {
        restaurant.setIncome(0);
        restaurantRepository.save(restaurant);
        return Message.SUCCESS;
    }

    @Override
    public Message update(String idCode, String phoneNumber, String name, String password, String type,Address address) {
        Restaurant restaurant = restaurantRepository.findByIdCode(idCode);
        restaurant.setChecked(false);
        restaurant.setPhoneNumber(phoneNumber);
        restaurant.setPassword(password);
        restaurant.setChangeName(name); // 待审核
        restaurant.setChangeType(type); // 待审核
        restaurantRepository.save(restaurant);
        Address address1 = addressRepository.findByCode(idCode).get(0);
        address1.setChangeProvince(address.getProvince()); // 待审核
        address1.setChangeCity(address.getCity()); // 待审核
        address1.setChangeDistrict(address.getDistrict()); // 待审核
        address1.setChangeDetail(address.getDetail()); // 待审核
        addressRepository.save(address1);
        return Message.SUCCESS;
    }

    @Override
    public Message updateAddress(Address address) {
        addressRepository.save(address);
        return Message.SUCCESS;
    }

    @Override
    public Message login(String idCode, String password) {
        Restaurant restaurant = restaurantRepository.findByIdCode(idCode);
        if(restaurant == null) {
            return Message.NOTFOUND;
        } else if(restaurant.getPassword().equals(password)) {
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    @Override
    public Message publishSingle(String idCode, Food food) {
        foodRepository.save(food);
        return Message.SUCCESS;
    }

    @Override
    public Message publishCombo(String idCode, ComboFood comboFood) {
        comboFoodRepository.save(comboFood);
        return Message.SUCCESS;
    }

    @Override
    public Restaurant findById(int id) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(id);
        return restaurant;
    }

    @Override
    public Restaurant findByIdCode(String idCode) {
        return restaurantRepository.findByIdCode(idCode);
    }

    @Override
    public ArrayList<Address> findAddressByIdCode(String idCode) {
        return addressRepository.findByCode(idCode);
    }

    @Override
    public Restaurant findByPhoneNumber(String phoneNumber) {
        Restaurant restaurant = restaurantRepository.findByPhoneNumber(phoneNumber);
        return restaurant;
    }
}
