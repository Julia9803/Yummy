package edu.nju.yummy.dao;

import edu.nju.yummy.entity.OrderFood;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface OrderFoodRepository extends CrudRepository<OrderFood,Integer> {
    OrderFood save(OrderFood orderFood);
    ArrayList<OrderFood> findByOid(int oid);
    ArrayList<OrderFood> findByOidAndTypeEquals(int oid, String type);
}
