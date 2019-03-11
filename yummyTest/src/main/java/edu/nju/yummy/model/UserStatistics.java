package edu.nju.yummy.model;

import java.util.HashMap;

public class UserStatistics {

    private int userNum;
    private double averageOrderNum;
    private double averagePayedNum;
    /**
     * uid paidRate
     */
    private HashMap<String,Double> paidRate;
    /**
     * grade userNumber
     */
    private HashMap<Integer,Integer> gradeNumber;
    /**
     * uid orderNumber
     */
    private HashMap<String,Integer> orderNumber;

    public UserStatistics() {}
    public UserStatistics(int userNum, double averageOrderNum, double averagePayedNum, HashMap<String,Double> paidRate, HashMap<Integer,Integer> gradeNumber, HashMap<String,Integer> orderNumber) {
        this.userNum = userNum;
        this.averageOrderNum = averageOrderNum;
        this.averagePayedNum = averagePayedNum;
        this.paidRate = paidRate;
        this.gradeNumber = gradeNumber;
        this.orderNumber = orderNumber;
    }

    public double getAverageOrderNum() {
        return averageOrderNum;
    }

    public void setAverageOrderNum(double averageOrderNum) {
        this.averageOrderNum = averageOrderNum;
    }

    public double getAveragePayedNum() {
        return averagePayedNum;
    }

    public void setAveragePayedNum(double averagePayedNum) {
        this.averagePayedNum = averagePayedNum;
    }

    public HashMap<String, Double> getPaidRate() {
        return paidRate;
    }

    public void setPaidRate(HashMap<String, Double> paidRate) {
        this.paidRate = paidRate;
    }

    public HashMap<Integer, Integer> getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(HashMap<Integer, Integer> gradeNumber) {
        this.gradeNumber = gradeNumber;
    }

    public HashMap<String, Integer> getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(HashMap<String, Integer> orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }
}
