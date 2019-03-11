package edu.nju.yummy.model;

import edu.nju.yummy.entity.Address;

import java.io.Serializable;

public class ResCheck implements Serializable {
    private String idCode;
    private String name;
    private String type;
    private Address address;

    public ResCheck () {}
    public ResCheck(String idCode,String name,String type,Address address) {
        this.idCode = idCode;
        this.name = name;
        this.type = type;
        this.address = address;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
}
