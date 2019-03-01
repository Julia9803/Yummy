package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.ComboFoodRepository;
import edu.nju.yummy.dao.FoodRepository;
import edu.nju.yummy.dao.RestaurantRepository;
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

    @Override
    public Message register(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return Message.SUCCESS;
    }

    @Override
    public Message update(String idCode, String phoneNumber, String name, String password, String type) {
        Restaurant restaurant = restaurantRepository.findByIdCode(idCode);
        restaurant.setChecked(false);
        restaurant.setIdCode(idCode);
        restaurant.setPhoneNumber(phoneNumber);
        restaurant.setName(name);
        restaurant.setPassword(password);
        restaurant.setType(type);
        return Message.SUCCESS;
    }

//    @Override
//    public Message changePhone(int restaurantId, String phoneNumber) {
//        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
//        restaurant.setPhoneNumber(phoneNumber);
//        restaurant.setChecked(false);
//        restaurantRepository.save(restaurant);
//        return Message.SUCCESS;
//    }
//
//    @Override
//    public Message changeName(int restaurantId, String name) {
//        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
//        restaurant.setName(name);
//        restaurantRepository.save(restaurant);
//        return Message.SUCCESS;
//    }
//
//    @Override
//    public Message changeAddress(int restaurantId, Address address) {
//        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
//        restaurant.setAddress(address);
//        restaurantRepository.save(restaurant);
//        return Message.SUCCESS;
//    }
//
//    @Override
//    public Message changeType(int restaurantId, String type) {
//        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
//        restaurant.setType(type);
//        restaurantRepository.save(restaurant);
//        return Message.SUCCESS;
//    }
//
//    @Override
//    public Message changePassword(int restaurantId, String password) {
//        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
//        restaurant.setPassword(password);
//        restaurantRepository.save(restaurant);
//        return Message.SUCCESS;
//    }

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
    public Message publishSingle(String idCode, Food food, int num) {
        Restaurant restaurant = restaurantRepository.findByIdCode(idCode);
        foodRepository.save(food);
        restaurant.getSingleNum().add(num + 1);
        restaurantRepository.save(restaurant);
        return Message.SUCCESS;
    }

    @Override
    public Message publishCombo(String idCode, ComboFood comboFood, int num) {
        Restaurant restaurant = restaurantRepository.findByIdCode(idCode);
        comboFoodRepository.save(comboFood);
        restaurant.getComboNum().add(num + 1);
        restaurantRepository.save(restaurant);
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
    public Restaurant findByPhoneNumber(String phoneNumber) {
        Restaurant restaurant = restaurantRepository.findByPhoneNumber(phoneNumber);
        return restaurant;
    }
}
