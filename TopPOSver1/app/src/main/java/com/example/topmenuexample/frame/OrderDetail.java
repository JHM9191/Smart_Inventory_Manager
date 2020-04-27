package com.example.topmenuexample.frame;

import java.io.Serializable;

public class OrderDetail implements Serializable {

    int imgSrc;
    String menuName;
    int menuCost;
    int menuCount;

    public OrderDetail() {
    }

    public OrderDetail(int imgSrc, String menuName, int menuCost, int menuCount) {
        this.imgSrc = imgSrc;
        this.menuName = menuName;
        this.menuCost = menuCost;
        this.menuCount = menuCount;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuCost() {
        return menuCost;
    }

    public void setMenuCost(int menuCost) {
        this.menuCost = menuCost;
    }

    public int getMenuCount() {
        return menuCount;
    }

    public void setMenuCount(int menuCount) {
        this.menuCount = menuCount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "imgSrc='" + imgSrc + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuCost=" + menuCost +
                ", menuCount=" + menuCount +
                '}';
    }
}
