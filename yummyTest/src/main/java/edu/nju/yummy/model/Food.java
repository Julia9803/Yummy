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
    private double price;
    private String restaurantIdCode;

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

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getRestaurantId() {
        return restaurantIdCode;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantIdCode = restaurantId;
    }
}
