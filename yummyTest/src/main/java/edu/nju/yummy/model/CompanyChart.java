package edu.nju.yummy.model;

import java.util.ArrayList;

public class CompanyChart {
    private ArrayList<String> rid;
    private ArrayList<Double> income;
    private ArrayList<String> uid;
    private ArrayList<Double> payment;

    public CompanyChart() {}
    public CompanyChart(ArrayList<String> rid, ArrayList<Double> income, ArrayList<String> uid, ArrayList<Double> payment) {
        this.rid = rid;
        this.income = income;
        this.uid = uid;
        this.payment = payment;
    }

    public ArrayList<String> getUid() {
        return uid;
    }

    public void setUid(ArrayList<String> uid) {
        this.uid = uid;
    }

    public ArrayList<String> getRid() {
        return rid;
    }

    public void setRid(ArrayList<String> rid) {
        this.rid = rid;
    }

    public ArrayList<Double> getIncome() {
        return income;
    }

    public void setIncome(ArrayList<Double> income) {
        this.income = income;
    }

    public ArrayList<Double> getPayment() {
        return payment;
    }

    public void setPayment(ArrayList<Double> payment) {
        this.payment = payment;
    }
}
