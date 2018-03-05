package com.cn.pojo;

public class Area {

    private Integer id;

    private Integer parentId;

    private String name;

    private String shortName;

    private Float longitude;//经度

    private Float latitude;//维度

    private Integer level;

    private Integer sort;

    private Integer status;//状态

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getParentId() { return parentId; }

    public void setParentId(Integer parentId) { this.parentId = parentId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getShortName() { return shortName; }

    public void setShortName(String shortName) { this.shortName = shortName; }

    public Float getLongitude() { return longitude; }

    public void setLongitude(Float longitude) { this.longitude = longitude; }

    public Float getLatitude() { return latitude; }

    public void setLatitude(Float latitude) { this.latitude = latitude; }

    public Integer getLevel() { return level; }

    public void setLevel(Integer level) { this.level = level; }

    public Integer getSort() { return sort; }

    public void setSort(Integer sort) { this.sort = sort; }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }
}
