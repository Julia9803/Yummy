package edu.nju.yummy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Entity
public class Order implements Serializable {

    public Order() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private String userPhone;
    private int restaurantId;
    private Date time;
    private boolean isCancelled;
    private boolean isPayed;
    private boolean isDelivered;
    private double discount;
    private double totalMoney;
    /**
     * food amount
     */
    private ArrayList<HashMap<Food,Integer>> foods;

    public ArrayList<HashMap<Food, Integer>> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<HashMap<Food, Integer>> foods) {
        this.foods = foods;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
