package edu.nju.yummy.model;

import java.util.HashMap;

public class CompanyFinance {

    private double totalIncome;
    /**
     * rid income
     */
    private HashMap<String,Double> ridIncome;
    /**
     * uid payment
     */
    private HashMap<String,Double> uidPayment;
    /**
     * month income
     */
//    private HashMap<String, Double> monthlyIncome;

    public CompanyFinance() {}
    public CompanyFinance(double totalIncome, HashMap<String,Double> ridIncome, HashMap<String,Double> uidPayment) {
        this.totalIncome = totalIncome;
        this.ridIncome = ridIncome;
        this.uidPayment = uidPayment;
    }


    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public HashMap<String, Double> getRidIncome() {
        return ridIncome;
    }

    public void setRidIncome(HashMap<String, Double> ridIncome) {
        this.ridIncome = ridIncome;
    }

    public HashMap<String, Double> getUidPayment() {
        return uidPayment;
    }

    public void setUidPayment(HashMap<String, Double> uidPayment) {
        this.uidPayment = uidPayment;
    }
}
