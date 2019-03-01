package edu.nju.yummy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Company implements Serializable {
    public Company() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    double income;
    String month;
    int rid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
