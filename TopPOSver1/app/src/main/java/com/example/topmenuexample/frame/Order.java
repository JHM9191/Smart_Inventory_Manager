package com.example.topmenuexample.frame;

import java.io.Serializable;

public class Order implements Serializable {

    String orderNo;
    String orderDate;
    int totalCount;
    int totalCost;

    public Order() {
    }

    public Order(String orderNo, String orderDate, int totalCount, int totalCost) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.totalCount = totalCount;
        this.totalCost = totalCost;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", totalCount=" + totalCount +
                ", totalCost=" + totalCost +
                '}';
    }
}
