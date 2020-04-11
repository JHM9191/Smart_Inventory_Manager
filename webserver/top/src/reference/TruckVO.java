package reference;

import java.time.LocalDateTime;

public class TruckVO {
	String truckID;
	String truckSize;
	double truckMaxWeight;
	double truckCurrentWeight;
	LocalDateTime truckRegDate;
	String truckDriverNAme;
	String truckState;
	String userID;

	public TruckVO() {

	}

	public TruckVO(String truckID, String truckSize, double truckMaxWeight, double truckCurrentWeight,
			LocalDateTime truckRegDate, String truckDriverNAme, String truckState, String userID) {
		super();
		this.truckID = truckID;
		this.truckSize = truckSize;
		this.truckMaxWeight = truckMaxWeight;
		this.truckCurrentWeight = truckCurrentWeight;
		this.truckRegDate = truckRegDate;
		this.truckDriverNAme = truckDriverNAme;
		this.truckState = truckState;
		this.userID = userID;
	}

	public String getTruckID() {
		return truckID;
	}

	public void setTruckID(String truckID) {
		this.truckID = truckID;
	}

	public String getTruckSize() {
		return truckSize;
	}

	public void setTruckSize(String truckSize) {
		this.truckSize = truckSize;
	}

	public double getTruckMaxWeight() {
		return truckMaxWeight;
	}

	public void setTruckMaxWeight(double truckMaxWeight) {
		this.truckMaxWeight = truckMaxWeight;
	}

	public double getTruckCurrentWeight() {
		return truckCurrentWeight;
	}

	public void setTruckCurrentWeight(double truckCurrentWeight) {
		this.truckCurrentWeight = truckCurrentWeight;
	}

	public LocalDateTime getTruckRegDate() {
		return truckRegDate;
	}

	public void setTruckRegDate(LocalDateTime truckRegDate) {
		this.truckRegDate = truckRegDate;
	}

	public String getTruckDriverNAme() {
		return truckDriverNAme;
	}

	public void setTruckDriverNAme(String truckDriverNAme) {
		this.truckDriverNAme = truckDriverNAme;
	}

	public String getTruckState() {
		return truckState;
	}

	public void setTruckState(String truckState) {
		this.truckState = truckState;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "TruckVO [truckID=" + truckID + ", truckSize=" + truckSize + ", truckMaxWeight=" + truckMaxWeight
				+ ", truckCurrentWeight=" + truckCurrentWeight + ", truckRegDate=" + truckRegDate + ", truckDriverNAme="
				+ truckDriverNAme + ", truckState=" + truckState + ", userID=" + userID + "]";
	}

}
