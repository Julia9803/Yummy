package edu.nju.yummy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class SingleFoodPack {
    public SingleFoodPack() {}

    public SingleFoodPack(Food food, int num) {
        this.food = food;
        this.num = num;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Food food;
    private int num;
    private Date date;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
