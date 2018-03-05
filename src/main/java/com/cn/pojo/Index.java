package com.cn.pojo;

import java.io.Serializable;

public class Index implements Serializable {
    private Integer id;

    private String belongs;

    private String field;

    private String index;

    private Integer display;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBelongs() {
        return belongs;
    }

    public void setBelongs(String table) {
        this.belongs = table == null ? null : table.trim();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index == null ? null : index.trim();
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }
}