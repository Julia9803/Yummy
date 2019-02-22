package edu.nju.yummy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ComboFoodPack {
    public ComboFoodPack() {}
    public ComboFoodPack(ComboFood foods, int num) {
        this.comboFood = foods;
        this.num = num;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private ComboFood comboFood;
    private int num;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public ComboFood getComboFood() {
        return comboFood;
    }

    public void setComboFood(ComboFood comboFood) {
        this.comboFood = comboFood;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
