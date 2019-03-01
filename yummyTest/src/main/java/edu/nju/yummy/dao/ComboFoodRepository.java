package edu.nju.yummy.dao;

import edu.nju.yummy.model.ComboFood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ComboFoodRepository extends CrudRepository<ComboFood,Integer> {
    ComboFood save(ComboFood food);
    ArrayList<ComboFood> findByRestaurantIdCode(String idCode);
    ComboFood findByComboId(int id);

}
