package edu.nju.yummy.model;

public class BagContent {
    private String idCode;
    private int foodId;
    private String name;
    private String type;
    private int orderNum;
    private double price;
    private String userPhone;

    public BagContent(String idCode, int foodId, String name, String type, int orderNum, double price, String userPhone) {
        this.idCode = idCode;
        this.foodId = foodId;
        this.name = name;
        this.type = type;
        this.orderNum = orderNum;
        this.price = price;
        this.userPhone = userPhone;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
