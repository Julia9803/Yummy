package edu.nju.yummy.service.impl;

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

    @Override
    public Message register(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return Message.SUCCESS;
    }

    @Override
    public Message update(int restaurantId, String phoneNumber, String name, Address address, String password, String type) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        restaurant.setChecked(false);
        restaurant.setPhoneNumber(phoneNumber);
        restaurant.setName(name);
        restaurant.setAddress(address);
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
    public Message login(int restaurantId, String password) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        if(restaurant == null) {
            return Message.NOTFOUND;
        } else if(restaurant.getPassword().equals(password)) {
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    @Override
    public Message publishSingle(int restaurantId, Food food) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        restaurant.getSingleFoods().add(food);
        restaurant.setSingleNum(restaurant.getSingleNum() + 1);
        restaurantRepository.save(restaurant);
        return Message.SUCCESS;
    }

    @Override
    public Message publishCombo(int restaurantId, ComboFood food) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        restaurant.getComboFoods().add(food);
        restaurant.setComboNum(restaurant.getComboNum() + 1);
        restaurantRepository.save(restaurant);
        return Message.SUCCESS;
    }

    @Override
    public Restaurant findById(int id) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(id);
        return restaurant;
    }

    @Override
    public Restaurant findByPhoneNumber(String phoneNumber) {
        Restaurant restaurant = restaurantRepository.findByPhoneNumber(phoneNumber);
        return restaurant;
    }
}
