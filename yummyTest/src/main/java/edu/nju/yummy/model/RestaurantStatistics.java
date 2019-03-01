package edu.nju.yummy.model;

import java.util.HashMap;

public class RestaurantStatistics {
    public RestaurantStatistics() {}
    public RestaurantStatistics(int resNum, double averageOrderNum, double averageCancelRate, HashMap<Integer,Double> cancelRate, HashMap<Integer,Integer> orderNumber) {
        this.resNum = resNum;
        this.averageOrderNum = averageOrderNum;
        this.averageCancelRate = averageCancelRate;
        this.cancelRate = cancelRate;
        this.orderNumber = orderNumber;
    }

    private int resNum;
    private double averageOrderNum;
    private double averageCancelRate;

    /**
     * rid cancelRate
     */
    private HashMap<Integer,Double> cancelRate;
    /**
     * rid orderNumber
     */
    private HashMap<Integer,Integer> orderNumber;

    public HashMap<Integer, Integer> getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(HashMap<Integer, Integer> orderNumber) {
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

    public HashMap<Integer, Double> getCancelRate() {
        return cancelRate;
    }

    public void setCancelRate(HashMap<Integer, Double> cancelRate) {
        this.cancelRate = cancelRate;
    }
}
