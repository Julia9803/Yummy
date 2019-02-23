package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.RestaurantRepository;
import edu.nju.yummy.model.*;
import edu.nju.yummy.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ManagerServiceBean implements ManagerService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public ArrayList<Restaurant> getResChange() {
        return restaurantRepository.findByChecked(false);
    }

    @Override
    public Message checkResChange(int rid, boolean res) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(rid);
        restaurant.setChecked(res);
        restaurantRepository.save(restaurant);
        if(!res) {
            return Message.FAIL;
        }
        return Message.SUCCESS;
    }

    @Override
    public RestaurantStatistics getResStat() {
        return null;
    }

    @Override
    public UserStatistics getUserStat() {
        return null;
    }

    @Override
    public CompanyFinance getCompanyFinanceStat() {
        return null;
    }
}
