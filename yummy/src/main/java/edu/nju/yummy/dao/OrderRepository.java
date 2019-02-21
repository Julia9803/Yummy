package edu.nju.yummy.dao;

import edu.nju.yummy.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {
    Order save(Order order);
    Order findByOrderId(int oid);
    ArrayList<Order> findByUserPhone(String phoneNumber);
    ArrayList<Order> findByRestaurantId(int rid);
}
