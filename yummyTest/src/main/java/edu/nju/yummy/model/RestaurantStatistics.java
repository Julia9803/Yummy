package edu.nju.yummy.model;

import java.util.HashMap;

public class RestaurantStatistics {

    private int resNum;
    private double averageOrderNum;
    private double averageCancelRate;

    /**
     * idCode cancelRate
     */
    private HashMap<String,Double> cancelRate;
    /**
     * idCode orderNumber
     */
    private HashMap<String,Integer> orderNumber;

    public RestaurantStatistics() {}
    public RestaurantStatistics(int resNum, double averageOrderNum, double averageCancelRate, HashMap<String,Double> cancelRate, HashMap<String,Integer> orderNumber) {
        this.resNum = resNum;
        this.averageOrderNum = averageOrderNum;
        this.averageCancelRate = averageCancelRate;
        this.cancelRate = cancelRate;
        this.orderNumber = orderNumber;
    }

    public HashMap<String, Integer> getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(HashMap<String, Integer> orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getAverageOrderNum() {
        return averageOrderNum;
    }

    public void setAverageOrderNum(double averageOrderNum) {
        this.averageOrderNum = averageOrderNum;
    }

    public double getAverageCancelRate() {
        return averageCancelRate;
    }

    public void setAverageCancelRate(double averageCancelRate) {
        this.averageCancelRate = averageCancelRate;
    }

    public int getResNum() {
        return resNum;
    }

    public void setResNum(int resNum) {
        this.resNum = resNum;
    }

    public HashMap<String, Double> getCancelRate() {
        return cancelRate;
    }

    public void setCancelRate(HashMap<String, Double> cancelRate) {
        this.cancelRate = cancelRate;
    }
}
