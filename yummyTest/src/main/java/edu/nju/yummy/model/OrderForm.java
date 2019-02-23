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
    private Address userAddress;
    private Date time;
    private boolean isCancelled;
    private boolean isPayed;
    private boolean isDelivering;
    private boolean isDelivered;
    private double discount;
    private double totalMoney;
    private ArrayList<Food> singleFood;
    private ArrayList<ComboFood> comboFood;
    private ArrayList<Integer> singleNum;
    private ArrayList<Integer> comboNum;

    public ArrayList<Integer> getSingleNum() {
        return singleNum;
    }

    public void setSingleNum(ArrayList<Integer> singleNum) {
        this.singleNum = singleNum;
    }

    public ArrayList<Integer> getComboNum() {
        return comboNum;
    }

    public void setComboNum(ArrayList<Integer> comboNum) {
        this.comboNum = comboNum;
    }

    public ArrayList<ComboFood> getComboFood() {
        return comboFood;
    }

    public void setComboFood(ArrayList<ComboFood> comboFood) {
        this.comboFood = comboFood;
    }

    public ArrayList<Food> getSingleFood() {
        return singleFood;
    }

    public void setSingleFood(ArrayList<Food> singleFood) {
        this.singleFood = singleFood;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
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

    public boolean isDelivering() {
        return isDelivering;
    }

    public void setDelivering(boolean delivering) {
        isDelivering = delivering;
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
