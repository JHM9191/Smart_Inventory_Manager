package com.example.topmenuexample.frame;

public class Sales {


    String sellDate;
    int sellCount;
    int sellCost;
    String admin;

    public Sales() {

    }

    public Sales(String sellDate, int sellCount, int sellCost, String admin) {
        this.sellDate = sellDate;
        this.sellCount = sellCount;
        this.sellCost = sellCost;
        this.admin = admin;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    public int getSellCost() {
        return sellCost;
    }

    public void setSellCost(int sellCost) {
        this.sellCost = sellCost;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "sellDate='" + sellDate + '\'' +
                ", sellCount=" + sellCount +
                ", sellCost=" + sellCost +
                ", admin='" + admin + '\'' +
                '}';
    }
}
