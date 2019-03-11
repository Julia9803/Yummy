package edu.nju.yummy.model;

import edu.nju.yummy.entity.Address;
import edu.nju.yummy.entity.OrderFood;

import java.util.ArrayList;
import java.util.Date;

public class HistoryOrderPresent {
    private int orderId;
    private String userPhone;
    private String restaurantIdCode;
    private Address userAddress;
    private Date time;
    private boolean cancelled;
    private boolean payed;
    private String deliverState;
    private boolean ensureDelivered;
    private double orderMoney; // 原价
    private double totalMoney; // 打折后
    private ArrayList<OrderFood> foods;

    public HistoryOrderPresent() {}
    public HistoryOrderPresent(int orderId,String userPhone,String restaurantIdCode,Address userAddress,Date time,boolean cancelled,boolean payed,String deliverState,boolean ensureDelivered,double orderMoney,double totalMoney,ArrayList<OrderFood> foods) {
        this.orderId = orderId;
        this.userPhone = userPhone;
        this.restaurantIdCode = restaurantIdCode;
        this.userAddress = userAddress;
        this.time = time;
        this.cancelled = cancelled;
        this.payed = payed;
        this.deliverState = deliverState;
        this.ensureDelivered = ensureDelivered;
        this.orderMoney = orderMoney;
        this.totalMoney = totalMoney;
        this.foods = foods;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getRestaurantIdCode() {
        return restaurantIdCode;
    }

    public void setRestaurantIdCode(String restaurantIdCode) {
        this.restaurantIdCode = restaurantIdCode;
    }

    public double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public boolean isEnsureDelivered() {
        return ensureDelivered;
    }

    public void setEnsureDelivered(boolean ensureDelivered) {
        this.ensureDelivered = ensureDelivered;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public ArrayList<OrderFood> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<OrderFood> foods) {
        this.foods = foods;
    }

    public String getDeliverState() {
        return deliverState;
    }

    public void setDeliverState(String deliverState) {
        this.deliverState = deliverState;
    }
}
