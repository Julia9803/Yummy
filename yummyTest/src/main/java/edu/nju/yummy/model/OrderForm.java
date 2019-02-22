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
public class OrderForm implements Serializable {

    public OrderForm() {}

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
    private ArrayList<SingleFoodPack> singleFoodPacks;
    private ArrayList<ComboFoodPack> comboFoodPacks;

    public void setSingleFoodPacks(ArrayList<SingleFoodPack> singleFoodPacks) {
        this.singleFoodPacks = singleFoodPacks;
    }

    public ArrayList<SingleFoodPack> getSingleFoodPacks() {
        return singleFoodPacks;
    }

    public void setComboFoodPacks(ArrayList<ComboFoodPack> comboFoodPacks) {
        this.comboFoodPacks = comboFoodPacks;
    }

    public ArrayList<ComboFoodPack> getComboFoodPacks() {
        return comboFoodPacks;
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

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
