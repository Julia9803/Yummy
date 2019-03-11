package edu.nju.yummy.model;

import java.util.ArrayList;

public class UserChart {
    private ArrayList<String> uid;
    private ArrayList<Double> paidRate;
    private ArrayList<Integer> grade;
    private ArrayList<Integer> userNumber;
    private ArrayList<Integer> orderNumber;

    public UserChart() {}
    public UserChart(ArrayList<String> uid, ArrayList<Double> paidRate, ArrayList<Integer> grade, ArrayList<Integer> userNumber, ArrayList<Integer> orderNumber) {
        this.grade = grade;
        this.orderNumber = orderNumber;
        this.paidRate = paidRate;
        this.uid = uid;
        this.userNumber = userNumber;
    }

    public ArrayList<Double> getPaidRate() {
        return paidRate;
    }

    public void setPaidRate(ArrayList<Double> paidRate) {
        this.paidRate = paidRate;
    }

    public ArrayList<Integer> getGrade() {
        return grade;
    }

    public void setGrade(ArrayList<Integer> grade) {
        this.grade = grade;
    }

    public ArrayList<Integer> getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(ArrayList<Integer> orderNumber) {
        this.orderNumber = orderNumber;
    }

    public ArrayList<Integer> getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(ArrayList<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    public ArrayList<String> getUid() {
        return uid;
    }

    public void setUid(ArrayList<String> uid) {
        this.uid = uid;
    }
}
