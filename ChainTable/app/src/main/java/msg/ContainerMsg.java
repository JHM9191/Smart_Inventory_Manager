package msg;

import java.io.Serializable;

public class ContainerMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    String conID;
    String conSize;
    double conMaxWeight;
    double conFullWeight;
    int conFullQuantity;
    double conWarningWeight;
    int conWarningQuantity;
    double conCurrWeight;
    int conCurrQuantity;
    double conUnitWeight;
    String ingID;
    String chainID;

    String message;
    String myIP;

    public ContainerMsg() {
    }

    public ContainerMsg(String chainID, String message, String myIP) {
        this.chainID = chainID;
        this.message = message;
        this.myIP = myIP;
    }

    public ContainerMsg(String conID, String conSize, double conMaxWeight, double conFullWeight, int conFullQuantity, double conWarningWeight, int conWarningQuantity, double conCurrWeight, int conCurrQuantity, double conUnitWeight, String ingID, String chainID) {
        this.conID = conID;
        this.conSize = conSize;
        this.conMaxWeight = conMaxWeight;
        this.conFullWeight = conFullWeight;
        this.conFullQuantity = conFullQuantity;
        this.conWarningWeight = conWarningWeight;
        this.conWarningQuantity = conWarningQuantity;
        this.conCurrWeight = conCurrWeight;
        this.conCurrQuantity = conCurrQuantity;
        this.conUnitWeight = conUnitWeight;
        this.ingID = ingID;
        this.chainID = chainID;
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

    public String getChainID() {
        return chainID;
    }

    public void setChainID(String chainID) {
        this.chainID = chainID;
    }

    @Override
    public String toString() {
        return "ContainerVO{" +
                "conID='" + conID + '\'' +
                ", conSize='" + conSize + '\'' +
                ", conMaxWeight=" + conMaxWeight +
                ", conFullWeight=" + conFullWeight +
                ", conFullQuantity=" + conFullQuantity +
                ", conWarningWeight=" + conWarningWeight +
                ", conWarningQuantity=" + conWarningQuantity +
                ", conCurrWeight=" + conCurrWeight +
                ", conCurrQuantity=" + conCurrQuantity +
                ", conUnitWeight=" + conUnitWeight +
                ", ingID='" + ingID + '\'' +
                ", chainID='" + chainID + '\'' +
                '}';
    }
}
