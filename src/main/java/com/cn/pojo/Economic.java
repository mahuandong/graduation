package com.cn.pojo;

public class Economic {
    private Integer id;

    private String areaCode;

    private Integer gdp;

    private String primary;

    private String second;

    private String third;

    private String taxRevenue;

    private String disposableIncome;

    private Double gdpRate;

    private Double primaryRate;

    private Double secondRate;

    private Double thirdRate;

    private Integer year;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public Integer getGdp() {
        return gdp;
    }

    public void setGdp(Integer gdp) {
        this.gdp = gdp;
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

    public String getTaxRevenue() {
        return taxRevenue;
    }

    public void setTaxRevenue(String taxRevenue) {
        this.taxRevenue = taxRevenue == null ? null : taxRevenue.trim();
    }

    public String getDisposableIncome() {
        return disposableIncome;
    }

    public void setDisposableIncome(String disposableIncome) {
        this.disposableIncome = disposableIncome == null ? null : disposableIncome.trim();
    }

    public Double getGdpRate() {
        return gdpRate;
    }

    public void setGdpRate(Double gdpRate) {
        this.gdpRate = gdpRate;
    }

    public Double getPrimaryRate() {
        return primaryRate;
    }

    public void setPrimaryRate(Double primaryRate) {
        this.primaryRate = primaryRate;
    }

    public Double getSecondRate() {
        return secondRate;
    }

    public void setSecondRate(Double secondRate) {
        this.secondRate = secondRate;
    }

    public Double getThirdRate() {
        return thirdRate;
    }

    public void setThirdRate(Double thirdRate) {
        this.thirdRate = thirdRate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}