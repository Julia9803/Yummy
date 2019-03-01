package edu.nju.yummy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class ComboFood implements Serializable {
    public ComboFood() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int comboId;
    private ArrayList<Integer> foodIds;
    private double price;
    private String restaurantIdCode;


    public ArrayList<Integer> getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(ArrayList<Integer> foodIds) {
        this.foodIds = foodIds;
    }

    public int getComboId() {
        return comboId;
    }

    public void setComboId(int comboId) {
        this.comboId = comboId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRestaurantIdCode() {
        return restaurantIdCode;
    }

    public void setRestaurantIdCode(String restaurantIdCode) {
        this.restaurantIdCode = restaurantIdCode;
    }
}
