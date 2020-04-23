package com.example.chaintablet.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class ContainerVO implements Parcelable {

    String conID;
    String conSize;
    double conMaxWeight;
    String conRegDate;
    String conUpdateDate;
    double conFullWeight;
    int conFullQuantity;
    double conWarningWeight;
    int conWarningQuantity;
    double conCurrWeight;
    int conCurrQuantity;
    double conUnitWeight;
    String ingID;
    String ingName;
    double ingWeight;
    String chainID;
    String chainName;
    String hqID;
    String hqName;


    public static final Creator<ContainerVO> CREATOR = new Creator<ContainerVO>() {
        @Override
        public ContainerVO createFromParcel(Parcel source) {
            return new ContainerVO(source);
        }

        @Override
        public ContainerVO[] newArray(int size) {
            return new ContainerVO[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(conID);
        dest.writeString(conSize);
        dest.writeDouble(conMaxWeight);
        dest.writeString(conRegDate);
        dest.writeString(conUpdateDate);
        dest.writeDouble(conFullWeight);
        dest.writeInt(conFullQuantity);
        dest.writeDouble(conWarningWeight);
        dest.writeInt(conWarningQuantity);
        dest.writeDouble(conCurrWeight);
        dest.writeInt(conCurrQuantity);
        dest.writeDouble(conUnitWeight);
        dest.writeString(ingID);
        dest.writeString(ingName);
        dest.writeDouble(ingWeight);
        dest.writeString(chainID);
        dest.writeString(chainName);
        dest.writeString(hqID);
        dest.writeString(hqName);
    }

//    public ContainerVO() {
//    }

    public ContainerVO(Parcel source) {

        conID = source.readString();
        conSize = source.readString();
        conMaxWeight = source.readDouble();
        conRegDate = source.readString();
        conUpdateDate = source.readString();
        conFullWeight = source.readDouble();
        conFullQuantity = source.readInt();
        conWarningWeight = source.readDouble();
        conWarningQuantity = source.readInt();
        conCurrWeight = source.readDouble();
        conCurrQuantity = source.readInt();
        conUnitWeight = source.readDouble();
        ingID = source.readString();
        ingName = source.readString();
        ingWeight = source.readDouble();
        chainID = source.readString();
        chainName = source.readString();
        hqID = source.readString();
        hqName = source.readString();
    }

    public ContainerVO(String conID, String conSize, double conMaxWeight, String conRegDate, String conUpdateDate, double conFullWeight, int conFullQuantity, double conWarningWeight, int conWarningQuantity, double conCurrWeight, int conCurrQuantity, double conUnitWeight, String ingID, String ingName, double ingWeight, String chainID, String chainName, String hqID, String hqName) {
        this.conID = conID;
        this.conSize = conSize;
        this.conMaxWeight = conMaxWeight;
        this.conRegDate = conRegDate;
        this.conUpdateDate = conUpdateDate;
        this.conFullWeight = conFullWeight;
        this.conFullQuantity = conFullQuantity;
        this.conWarningWeight = conWarningWeight;
        this.conWarningQuantity = conWarningQuantity;
        this.conCurrWeight = conCurrWeight;
        this.conCurrQuantity = conCurrQuantity;
        this.conUnitWeight = conUnitWeight;
        this.ingID = ingID;
        this.ingName = ingName;
        this.ingWeight = ingWeight;
        this.chainID = chainID;
        this.chainName = chainName;
        this.hqID = hqID;
        this.hqName = hqName;
    }


    public ContainerVO() {
    }

    public String getConID() {
        return conID;
    }

    public void setConID(String conID) {
        this.conID = conID;
    }

    public String getConSize() {
        return conSize;
    }

    public void setConSize(String conSize) {
        this.conSize = conSize;
    }

    public double getConMaxWeight() {
        return conMaxWeight;
    }

    public void setConMaxWeight(double conMaxWeight) {
        this.conMaxWeight = conMaxWeight;
    }

    public String getConRegDate() {
        return conRegDate;
    }

    public void setConRegDate(String conRegDate) {
        this.conRegDate = conRegDate;
    }

    public String getConUpdateDate() {
        return conUpdateDate;
    }

    public void setConUpdateDate(String conUpdateDate) {
        this.conUpdateDate = conUpdateDate;
    }

    public double getConFullWeight() {
        return conFullWeight;
    }

    public void setConFullWeight(double conFullWeight) {
        this.conFullWeight = conFullWeight;
    }

    public int getConFullQuantity() {
        return conFullQuantity;
    }

    public void setConFullQuantity(int conFullQuantity) {
        this.conFullQuantity = conFullQuantity;
    }

    public double getConWarningWeight() {
        return conWarningWeight;
    }

    public void setConWarningWeight(double conWarningWeight) {
        this.conWarningWeight = conWarningWeight;
    }

    public int getConWarningQuantity() {
        return conWarningQuantity;
    }

    public void setConWarningQuantity(int conWarningQuantity) {
        this.conWarningQuantity = conWarningQuantity;
    }

    public double getConCurrWeight() {
        return conCurrWeight;
    }

    public void setConCurrWeight(double conCurrWeight) {
        this.conCurrWeight = conCurrWeight;
    }

    public int getConCurrQuantity() {
        return conCurrQuantity;
    }

    public void setConCurrQuantity(int conCurrQuantity) {
        this.conCurrQuantity = conCurrQuantity;
    }

    public double getConUnitWeight() {
        return conUnitWeight;
    }

    public void setConUnitWeight(double conUnitWeight) {
        this.conUnitWeight = conUnitWeight;
    }

    public String getIngID() {
        return ingID;
    }

    public void setIngID(String ingID) {
        this.ingID = ingID;
    }

    public String getIngName() {
        return ingName;
    }

    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    public double getIngWeight() {
        return ingWeight;
    }

    public void setIngWeight(double ingWeight) {
        this.ingWeight = ingWeight;
    }

    public String getChainID() {
        return chainID;
    }

    public void setChainID(String chainID) {
        this.chainID = chainID;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    public String getHqID() {
        return hqID;
    }

    public void setHqID(String hqID) {
        this.hqID = hqID;
    }

    public String getHqName() {
        return hqName;
    }

    public void setHqName(String hqName) {
        this.hqName = hqName;
    }

    public static Creator<ContainerVO> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "ContainerVO{" +
                "conID='" + conID + '\'' +
                ", conSize='" + conSize + '\'' +
                ", conMaxWeight=" + conMaxWeight +
                ", conRegDate='" + conRegDate + '\'' +
                ", conUpdateDate='" + conUpdateDate + '\'' +
                ", conFullWeight=" + conFullWeight +
                ", conFullQuantity=" + conFullQuantity +
                ", conWarningWeight=" + conWarningWeight +
                ", conWarningQuantity=" + conWarningQuantity +
                ", conCurrWeight=" + conCurrWeight +
                ", conCurrQuantity=" + conCurrQuantity +
                ", conUnitWeight=" + conUnitWeight +
                ", ingID='" + ingID + '\'' +
                ", ingName='" + ingName + '\'' +
                ", ingWeight=" + ingWeight +
                ", chainID='" + chainID + '\'' +
                ", chainName='" + chainName + '\'' +
                ", hqID='" + hqID + '\'' +
                ", hqName='" + hqName + '\'' +
                '}';
    }
}
