package edu.nju.yummy.dao;

import edu.nju.yummy.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant,Integer> {
    Restaurant save(Restaurant restaurant);
    Restaurant findByRestaurantId(int id);
    ArrayList<Restaurant> findAll();
}
