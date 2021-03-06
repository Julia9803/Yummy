package edu.nju.yummy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String province;
    private String city;
    private String district;
    private String detail;
    private String code; // user:email res:idCode
    private String changeProvince;
    private String changeCity;
    private String changeDistrict;
    private String changeDetail;
    private boolean chosen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getChangeCity() {
        return changeCity;
    }

    public void setChangeCity(String changeCity) {
        this.changeCity = changeCity;
    }

    public String getChangeDetail() {
        return changeDetail;
    }

    public void setChangeDetail(String changeDetail) {
        this.changeDetail = changeDetail;
    }

    public String getChangeProvince() {
        return changeProvince;
    }

    public void setChangeProvince(String changeProvince) {
        this.changeProvince = changeProvince;
    }

    public String getChangeDistrict() {
        return changeDistrict;
    }

    public void setChangeDistrict(String changeDistrict) {
        this.changeDistrict = changeDistrict;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }
}
