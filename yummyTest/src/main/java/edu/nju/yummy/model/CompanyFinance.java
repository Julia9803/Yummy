package edu.nju.yummy.model;

import java.util.HashMap;

public class CompanyFinance {
    private int totalIncome;
    /**
     * rid income
     */
    private HashMap<Integer,Double> ridIncome;
    /**
     * uid payment
     */
    private HashMap<Integer,Integer> uidPayment;
    /**
     * month income
     */
    private HashMap<String, Double> monthlyIncome;

}
