package edu.nju.yummy.model;

import java.util.HashMap;

public class CompanyFinance {
    public CompanyFinance() {}
    public CompanyFinance(double totalIncome, HashMap<Integer,Double> ridIncome, HashMap<String,Double> uidPayment) {
        this.totalIncome = totalIncome;
        this.ridIncome = ridIncome;
        this.uidPayment = uidPayment;
    }

    private double totalIncome;
    /**
     * rid income
     */
    private HashMap<Integer,Double> ridIncome;
    /**
     * uid payment
     */
    private HashMap<String,Double> uidPayment;
    /**
     * month income
     */
//    private HashMap<String, Double> monthlyIncome;


    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public HashMap<Integer, Double> getRidIncome() {
        return ridIncome;
    }

    public void setRidIncome(HashMap<Integer, Double> ridIncome) {
        this.ridIncome = ridIncome;
    }

    public HashMap<String, Double> getUidPayment() {
        return uidPayment;
    }

    public void setUidPayment(HashMap<String, Double> uidPayment) {
        this.uidPayment = uidPayment;
    }
}
