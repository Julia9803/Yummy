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

    /**
     * user stat
     * @param phoneNumber
     * @return
     */
    ArrayList<OrderForm> findByUserPhoneOrderByTimeDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneOrderByTotalMoneyDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneOrderByRestaurantId(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneAndCancelledTrueOrderByTimeDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneAndCancelledTrueOrderByTotalMoneyDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneAndCancelledTrueOrderByRestaurantIdDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneAndPayedTrueOrderByTimeDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneAndPayedTrueOrderByTotalMoneyDesc(String phoneNumber);
    ArrayList<OrderForm> findByUserPhoneAndPayedTrueOrderByRestaurantId(String phoneNumber);

    /**
     * res stat
     * @param rid
     * @return
     */
    ArrayList<OrderForm> findByRestaurantIdAndDeliveringTrueOrDeliveredTrueOrderByTimeDesc(int rid);
    ArrayList<OrderForm> findByRestaurantIdOrderByTimeDesc(int id);
    ArrayList<OrderForm> findByRestaurantIdOrderByTotalMoneyDesc(int id);
    ArrayList<OrderForm> findByRestaurantIdOrderByUserPhone(int id);
    ArrayList<OrderForm> findByRestaurantIdAndCancelledTrueOrderByTimeDesc(int id);
    ArrayList<OrderForm> findByRestaurantIdAndCancelledTrueOrderByTotalMoneyDesc(int id);
    ArrayList<OrderForm> findByRestaurantIdAndCancelledTrueOrderByUserPhone(int id);
    ArrayList<OrderForm> findByRestaurantIdAndPayedTrueOrderByTimeDesc(int id);
    ArrayList<OrderForm> findByRestaurantIdAndPayedTrueOrderByTotalMoneyDesc(int id);
    ArrayList<OrderForm> findByRestaurantIdAndPayedTrueOrderByUserPhone(int id);

    /**
     * manager stat res
     * @param
     * @return
     */
    ArrayList<OrderForm> findAllByCancelledTrueOrderByRestaurantId();
    ArrayList<OrderForm> findAllByPayedTrueOrderByUserPhone();
    long countByUserPhone(String phoneNumber);
    long countByRestaurantId(int id);
    long count();
    long countByRestaurantIdAndCancelledTrue(int rid);
    long countByUserPhoneAndPayedTrue(String phoneNumber);
}
