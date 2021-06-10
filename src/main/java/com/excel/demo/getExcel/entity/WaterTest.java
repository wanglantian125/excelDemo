package com.excel.demo.getExcel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

@KeySequence()
public class WaterTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String year;
    private String city;
    private double peopleAll;
    private double gdp;
    private double peopleCity;
    private double waterAll;
    private double waterLife;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPeopleAll() {
        return peopleAll;
    }

    public void setPeopleAll(double peopleAll) {
        this.peopleAll = peopleAll;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public double getPeopleCity() {
        return peopleCity;
    }

    public void setPeopleCity(double peopleCity) {
        this.peopleCity = peopleCity;
    }

    public double getWaterAll() {
        return waterAll;
    }

    public void setWaterAll(double waterAll) {
        this.waterAll = waterAll;
    }

    public double getWaterLife() {
        return waterLife;
    }

    public void setWaterLife(double waterLife) {
        this.waterLife = waterLife;
    }

    @Override
    public String toString() {
        return "WaterTest{" +
                "id='" + id + '\'' +
                ", year='" + year + '\'' +
                ", city='" + city + '\'' +
                ", peopleAll='" + peopleAll + '\'' +
                ", gdp='" + gdp + '\'' +
                ", peopleCity='" + peopleCity + '\'' +
                ", waterAll='" + waterAll + '\'' +
                ", waterLife='" + waterLife + '\'' +
                '}';
    }
}
