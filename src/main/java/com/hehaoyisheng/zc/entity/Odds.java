package com.hehaoyisheng.zc.entity;

public class Odds {
    private Integer id;
    private Integer number;
    private String name;
    private double index;
    private double ping;
    private double ke;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    public double getPing() {
        return ping;
    }

    public void setPing(double ping) {
        this.ping = ping;
    }

    public double getKe() {
        return ke;
    }

    public void setKe(double ke) {
        this.ke = ke;
    }
}
