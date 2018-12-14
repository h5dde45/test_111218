package com.example.demo.domain;

public class Card {
    private Integer id;
    private String colorInfo;
    private String badge;
    private String disable;

    public Card(Integer id, String colorInfo, String badge, String disable) {
        this.id = id;
        this.colorInfo = colorInfo;
        this.badge = badge;
        this.disable = disable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColorInfo() {
        return colorInfo;
    }

    public void setColorInfo(String colorInfo) {
        this.colorInfo = colorInfo;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }
}
