package edu.nju.yummy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Restaurant implements Serializable {

    public Restaurant() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int restaurantId;
    private String name;
    private String address;
    private String type;
    private String password;
    private String phoneNumber;
    private ArrayList<SingleFoodPack> singleFoodPacks;
    private ArrayList<ComboFoodPack> comboFoodPacks;
    private ArrayList<OrderForm> orderForms;

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<ComboFoodPack> getComboFoodPacks() {
        return comboFoodPacks;
    }

    public void setComboFoodPacks(ArrayList<ComboFoodPack> comboFoodPacks) {
        this.comboFoodPacks = comboFoodPacks;
    }

    public ArrayList<SingleFoodPack> getSingleFoodPacks() {
        return singleFoodPacks;
    }

    public void setSingleFoodPacks(ArrayList<SingleFoodPack> singleFoodPacks) {
        this.singleFoodPacks = singleFoodPacks;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<OrderForm> getOrderForms() {
        return orderForms;
    }

    public void setOrderForms(ArrayList<OrderForm> orderForms) {
        this.orderForms = orderForms;
    }
}
