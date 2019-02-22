package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.RestaurantRepository;
import edu.nju.yummy.model.*;
import edu.nju.yummy.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Message changePhone(int restaurantId, String phoneNumber) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        restaurant.setPhoneNumber(phoneNumber);
        restaurantRepository.save(restaurant);
        return Message.SUCCESS;
    }

    @Override
    public Message changeName(int restaurantId, String name) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        restaurant.setName(name);
        restaurantRepository.save(restaurant);
        return Message.SUCCESS;
    }

    @Override
    public Message changeAddress(int restaurantId, String address) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        restaurant.setAddress(address);
        restaurantRepository.save(restaurant);
        return Message.SUCCESS;
    }

    @Override
    public Message changeType(int restaurantId, String type) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        restaurant.setType(type);
        restaurantRepository.save(restaurant);
        return Message.SUCCESS;
    }

    @Override
    public Message changePassword(int restaurantId, String password) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        restaurant.setPassword(password);
        restaurantRepository.save(restaurant);
        return Message.SUCCESS;
    }

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
    public Message publishSingle(int restaurantId, SingleFoodPack pack) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        restaurant.getSingleFoodPacks().add(pack);
        restaurantRepository.save(restaurant);
        return Message.SUCCESS;
    }

    @Override
    public Message publishCombo(int restaurantId, ComboFoodPack pack) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        restaurant.getComboFoodPacks().add(pack);
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
