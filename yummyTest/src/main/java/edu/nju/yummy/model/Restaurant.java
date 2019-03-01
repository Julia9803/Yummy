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
    private String idCode;
    private String name;
    private String type;
    private String password;
    private String phoneNumber;
    private boolean checked;
    private double income;
//    private ArrayList<Food> singleFoods;
//    private ArrayList<ComboFood> comboFoods;
    private ArrayList<Integer> singleNum;
    private ArrayList<Integer> comboNum;
//    private ArrayList<OrderForm> orderForms;

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
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
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
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
}
