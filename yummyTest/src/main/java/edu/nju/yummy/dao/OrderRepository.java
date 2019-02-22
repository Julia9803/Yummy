package edu.nju.yummy.dao;

import edu.nju.yummy.model.OrderForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderRepository extends CrudRepository<OrderForm,Integer> {
    OrderForm save(OrderForm orderForm);
    OrderForm findByOrderId(int oid);
    ArrayList<OrderForm> findByUserPhone(String phoneNumber);
    ArrayList<OrderForm> findByRestaurantId(int rid);
}
