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
    private int id;
    private ArrayList<Food> foods;
    private double price;

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
