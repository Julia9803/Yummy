package edu.nju.yummy.model;

import java.util.ArrayList;

public class RestaurantPresent {
    public RestaurantPresent() {}

    private String idCode;
    private String resName;
    private ArrayList<String> foodNames;
    private ArrayList<Integer> foodIds;
    private ArrayList<Integer> foodNums;
    private ArrayList<String> foodTypes;
    private ArrayList<Double> foodPrices;
    private ArrayList<String> comboFoodNames;
    private ArrayList<Integer> comboFoodIds;
    private ArrayList<Integer> comboFoodNums;
    private ArrayList<Double> comboFoodPrices;

    public RestaurantPresent(String idCode, String resName,
                             ArrayList<String> foodNames, ArrayList<Integer> foodIds, ArrayList<Integer> foodNums,ArrayList<String> foodTypes, ArrayList<Double> foodPrices,
                             ArrayList<String> comboFoodNames, ArrayList<Integer> comboFoodIds, ArrayList<Integer> comboFoodNums, ArrayList<Double> comboFoodPrices) {
        this.idCode = idCode;
        this.resName = resName;
        this.foodNames = foodNames;
        this.foodIds = foodIds;
        this.foodNums = foodNums;
        this.foodTypes = foodTypes;
        this.foodPrices = foodPrices;
        this.comboFoodNames = comboFoodNames;
        this.comboFoodIds = comboFoodIds;
        this.comboFoodNums = comboFoodNums;
        this.comboFoodPrices = comboFoodPrices;
    }

    public ArrayList<String> getFoodNames() {
        return foodNames;
    }

    public void setFoodNames(ArrayList<String> foodNames) {
        this.foodNames = foodNames;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public ArrayList<Integer> getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(ArrayList<Integer> foodIds) {
        this.foodIds = foodIds;
    }

    public ArrayList<Double> getFoodPrices() {
        return foodPrices;
    }

    public void setFoodPrices(ArrayList<Double> foodPrices) {
        this.foodPrices = foodPrices;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public ArrayList<Integer> getFoodNums() {
        return foodNums;
    }

    public void setFoodNums(ArrayList<Integer> foodNums) {
        this.foodNums = foodNums;
    }

    public ArrayList<String> getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(ArrayList<String> foodTypes) {
        this.foodTypes = foodTypes;
    }

    public ArrayList<Double> getComboFoodPrices() {
        return comboFoodPrices;
    }

    public void setComboFoodPrices(ArrayList<Double> comboFoodPrices) {
        this.comboFoodPrices = comboFoodPrices;
    }

    public ArrayList<Integer> getComboFoodIds() {
        return comboFoodIds;
    }

    public void setComboFoodIds(ArrayList<Integer> comboFoodIds) {
        this.comboFoodIds = comboFoodIds;
    }

    public ArrayList<Integer> getComboFoodNums() {
        return comboFoodNums;
    }

    public void setComboFoodNums(ArrayList<Integer> comboFoodNums) {
        this.comboFoodNums = comboFoodNums;
    }

    public ArrayList<String> getComboFoodNames() {
        return comboFoodNames;
    }

    public void setComboFoodNames(ArrayList<String> comboFoodNames) {
        this.comboFoodNames = comboFoodNames;
    }
}
