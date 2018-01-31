package com.cn.pojo;

public class Happen {
    private Integer id;

    private String areaCode;

    private Integer population;

    private Integer laborForce;

    private String primary;

    private String second;

    private String third;

    private Integer year;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getLaborForce() {
        return laborForce;
    }

    public void setLaborForce(Integer laborForce) {
        this.laborForce = laborForce;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary == null ? null : primary.trim();
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second == null ? null : second.trim();
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third == null ? null : third.trim();
    }

    public Integer getYear() { return year; }

    public void setYear(Integer year) { this.year = year; }
}