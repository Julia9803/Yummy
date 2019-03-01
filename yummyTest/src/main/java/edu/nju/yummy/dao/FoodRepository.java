package edu.nju.yummy.dao;

import edu.nju.yummy.model.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FoodRepository extends CrudRepository<Food,Integer> {
    Food save(Food food);
    Food findByFoodId(int fid);
    ArrayList<Food> findByRestaurantIdCode(String idCode);
    void delete(Food food);
}
