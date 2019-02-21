package edu.nju.yummy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Food implements Serializable {

    public Food() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int foodId;
    private String name;
    private String price;
    private String num;
    private boolean isCombo;
    private String restaurantId;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isCombo() {
        return isCombo;
    }

    public void setCombo(boolean combo) {
        isCombo = combo;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
}
