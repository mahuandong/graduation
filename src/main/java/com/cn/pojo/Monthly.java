package com.cn.pojo;

public class Monthly {
    private Integer id;

    private Integer year;

    private String areaCode;

    private Float one;

    private Float feb;

    private Float three;

    private Float four;

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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public Float getOne() {
        return one;
    }

    public void setOne(Float one) {
        this.one = one;
    }

    public Float getFeb() {
        return feb;
    }

    public void setFeb(Float feb) {
        this.feb = feb;
    }

    public Float getThree() {
        return three;
    }

    public void setThree(Float three) {
        this.three = three;
    }

    public Float getFour() {
        return four;
    }

    public void setFour(Float four) {
        this.four = four;
    }
}