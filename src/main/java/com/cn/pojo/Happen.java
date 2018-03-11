package com.cn.pojo;

import java.io.Serializable;

public class Happen implements Serializable {
    private Integer id;

    private Integer year;

    private Integer areaCode;

    private Integer population;

    private Float birth;

    private Float death;

    private Float growth;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Float getBirth() {
        return birth;
    }

    public void setBirth(Float birth) {
        this.birth = birth;
    }

    public Float getDeath() {
        return death;
    }

    public void setDeath(Float death) {
        this.death = death;
    }

    public Float getGrowth() {
        return growth;
    }

    public void setGrowth(Float growth) {
        this.growth = growth;
    }
}