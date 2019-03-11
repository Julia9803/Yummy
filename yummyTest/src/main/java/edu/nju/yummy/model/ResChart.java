package edu.nju.yummy.model;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;

public class ResChart {
    private ArrayList<String> resIdCode;
    private ArrayList<Double> cancelRate;
    private ArrayList<Integer> orderNumber;

    public ResChart() {}
    public ResChart(ArrayList<String> resIdCode, ArrayList<Double> cancelRate, ArrayList<Integer> orderNumber) {
        this.resIdCode = resIdCode;
        this.cancelRate = cancelRate;
        this.orderNumber = orderNumber;
    }

    public ArrayList<Double> getCancelRate() {
        return cancelRate;
    }

    public void setCancelRate(ArrayList<Double> cancelRate) {
        this.cancelRate = cancelRate;
    }

    public ArrayList<Integer> getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(ArrayList<Integer> orderNumber) {
        this.orderNumber = orderNumber;
    }

    public ArrayList<String> getResIdCode() {
        return resIdCode;
    }

    public void setResIdCode(ArrayList<String> resIdCode) {
        this.resIdCode = resIdCode;
    }
}
