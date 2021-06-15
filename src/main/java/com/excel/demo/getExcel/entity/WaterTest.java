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
    private double waterOfGdp;
    private double gdpOfPeppleAll;
    private double lifeInAll;

    private double detes;
    private double detet;
    private double detee;
    private double detep;
    private double detedw;
    private double detedws;

    public double getDetedws() {
        return detedws;
    }

    public void setDetedws(double detedws) {
        this.detedws = detedws;
    }

    public double getDetedw() {
        return detedw;
    }

    public void setDetedw(double detedw) {
        this.detedw = detedw;
    }

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

    public double getWaterOfGdp() {
        return waterOfGdp;
    }

    public void setWaterOfGdp(double waterOfGdp) {
        this.waterOfGdp = waterOfGdp;
    }

    public double getGdpOfPeppleAll() {
        return gdpOfPeppleAll;
    }

    public void setGdpOfPeppleAll(double gdpOfPeppleAll) {
        this.gdpOfPeppleAll = gdpOfPeppleAll;
    }


    public double getLifeInAll() {
        return lifeInAll;
    }

    public void setLifeInAll(double lifeInAll) {
        this.lifeInAll = lifeInAll;
    }

    public double getDetes() {
        return detes;
    }

    public void setDetes(double detes) {
        this.detes = detes;
    }

    public double getDetet() {
        return detet;
    }

    public void setDetet(double detet) {
        this.detet = detet;
    }

    public double getDetee() {
        return detee;
    }

    public void setDetee(double detee) {
        this.detee = detee;
    }

    public double getDetep() {
        return detep;
    }

    public void setDetep(double detep) {
        this.detep = detep;
    }
}
