package edu.nju.yummy.entity;

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
    private String restaurantIdCode;
    private int userAddressId;
    private Date time;
    private boolean cancelled;
    private boolean payed;
    private boolean delivering;
    private boolean delivered;
    private boolean ensureDelivered;
    private double discount;
    private double orderMoney; // 原价
    private double totalMoney; // 打折后


    public String getRestaurantIdCode() {
        return restaurantIdCode;
    }

    public void setRestaurantIdCode(String restaurantIdCode) {
        this.restaurantIdCode = restaurantIdCode;
    }

    public int getUserAddressId() {
        return userAddressId;
    }

    public void setUserAddressId(int userAddressId) {
        this.userAddressId = userAddressId;
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

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public boolean isDelivering() {
        return delivering;
    }

    public void setDelivering(boolean delivering) {
        this.delivering = delivering;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public boolean isEnsureDelivered() {
        return ensureDelivered;
    }

    public void setEnsureDelivered(boolean ensureDelivered) {
        this.ensureDelivered = ensureDelivered;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(double orderMoney) {
        this.orderMoney = orderMoney;
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
