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
    private Address address;
    private String type;
    private String password;
    private String phoneNumber;
    private boolean isChecked;
    private ArrayList<Food> singleFoods;
    private ArrayList<ComboFood> comboFoods;
    private ArrayList<Integer> singleNum;
    private ArrayList<Integer> comboNum;
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

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public ArrayList<ComboFood> getComboFoods() {
        return comboFoods;
    }

    public void setComboFoods(ArrayList<ComboFood> comboFoods) {
        this.comboFoods = comboFoods;
    }

    public ArrayList<Food> getSingleFoods() {
        return singleFoods;
    }

    public void setSingleFoods(ArrayList<Food> singleFoods) {
        this.singleFoods = singleFoods;
    }

    public ArrayList<Integer> getComboNum() {
        return comboNum;
    }

    public void setComboNum(ArrayList<Integer> comboNum) {
        this.comboNum = comboNum;
    }

    public ArrayList<Integer> getSingleNum() {
        return singleNum;
    }

    public void setSingleNum(ArrayList<Integer> singleNum) {
        this.singleNum = singleNum;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<OrderForm> getOrderForms() {
        return orderForms;
    }

    public void setOrderForms(ArrayList<OrderForm> orderForms) {
        this.orderForms = orderForms;
    }
}
