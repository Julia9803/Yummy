package edu.nju.yummy.dao;

import edu.nju.yummy.model.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface FoodRepository extends CrudRepository<Food,Integer> {
    Food save(Food food);
    Food findByFoodId(int fid);
    ArrayList<Food> findByRestaurantId(int rid);
    void delete(Food food);
}
