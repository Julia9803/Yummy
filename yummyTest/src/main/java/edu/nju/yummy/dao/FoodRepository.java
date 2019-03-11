package edu.nju.yummy.dao;

import edu.nju.yummy.entity.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FoodRepository extends CrudRepository<Food,Integer> {
    Food save(Food food);
    Food findByFoodId(int fid);
    Food findByName(String name); // 规定 食品名称唯一
    ArrayList<Food> findByRestaurantIdCode(String idCode);
    void delete(Food food);
}
