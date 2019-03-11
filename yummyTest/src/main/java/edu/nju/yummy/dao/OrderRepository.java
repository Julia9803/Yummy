package edu.nju.yummy.dao;

import edu.nju.yummy.entity.OrderForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderRepository extends CrudRepository<OrderForm,Integer> {
    OrderForm save(OrderForm orderForm);
    OrderForm findByOrderId(int oid);
    ArrayList<OrderForm> findByUserPhone(String phoneNumber);
    ArrayList<OrderForm> findByRestaurantIdCode(String idCode);

    /**
     * user stat
     * @param phoneNumber
     * @return
     */
    ArrayList<OrderForm> findByUserPhoneOrderByTimeDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneOrderByTotalMoneyDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneOrderByRestaurantIdCode(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneAndCancelledTrueOrderByTimeDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneAndCancelledTrueOrderByTotalMoneyDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneAndCancelledTrueOrderByRestaurantIdCodeDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneAndPayedTrueOrderByTimeDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneAndPayedTrueOrderByTotalMoneyDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneAndPayedTrueOrderByRestaurantIdCode(String phoneNumber);

    /**
     * res stat
     * @param idCode
     * @return
     */
    ArrayList<OrderForm> findByRestaurantIdCodeOrderByTimeDesc(String idCode);
    ArrayList<OrderForm> findByRestaurantIdCodeOrderByTotalMoneyDesc(String idCode);
    ArrayList<OrderForm> findByRestaurantIdCodeOrderByUserPhone(String idCode);
    ArrayList<OrderForm> findByRestaurantIdCodeAndCancelledTrueOrderByTimeDesc(String idCode);
    ArrayList<OrderForm> findByRestaurantIdCodeAndCancelledTrueOrderByTotalMoneyDesc(String idCode);
    ArrayList<OrderForm> findByRestaurantIdCodeAndCancelledTrueOrderByUserPhone(String idCode);
    ArrayList<OrderForm> findByRestaurantIdCodeAndPayedTrueOrderByTimeDesc(String idCode);
    ArrayList<OrderForm> findByRestaurantIdCodeAndPayedTrueOrderByTotalMoneyDesc(String idCode);
    ArrayList<OrderForm> findByRestaurantIdCodeAndPayedTrueOrderByUserPhone(String idCode);

    /**
     * manager stat res
     * @param
     * @return
     */
    ArrayList<OrderForm> findAllByCancelledTrueOrderByRestaurantIdCode();
    ArrayList<OrderForm> findAllByPayedTrueOrderByUserPhone();
    long countByUserPhone(String phoneNumber);
    long countByRestaurantIdCode(String idCode);
    long count();
    long countByRestaurantIdCodeAndCancelledTrue(String idCode);
    long countByUserPhoneAndPayedTrue(String phoneNumber);
}
