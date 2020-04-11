package reference;

import java.time.LocalDateTime;

public class InventoryVO {

	String inventoryID;
	double inventoryPayment;
	LocalDateTime inventoryDate;
	LocalDateTime inventoryExpireDate;
	double inventoryInitialWeight;
	int inventoryInitialQuantity;
	double inventoryCurrentWeight;
	int inventoryCurrentQuantity;
	String userID;
	String ingredientID;
	String chainID;
	String truckID;
	String containerID;

	public InventoryVO() {

	}

	public InventoryVO(String inventoryID, double inventoryPayment, LocalDateTime inventoryDate,
			LocalDateTime inventoryExpireDate, double inventoryInitialWeight, int inventoryInitialQuantity,
			double inventoryCurrentWeight, int inventoryCurrentQuantity, String userID, String ingredientID,
			String chainID, String truckID, String containerID) {
		super();
		this.inventoryID = inventoryID;
		this.inventoryPayment = inventoryPayment;
		this.inventoryDate = inventoryDate;
		this.inventoryExpireDate = inventoryExpireDate;
		this.inventoryInitialWeight = inventoryInitialWeight;
		this.inventoryInitialQuantity = inventoryInitialQuantity;
		this.inventoryCurrentWeight = inventoryCurrentWeight;
		this.inventoryCurrentQuantity = inventoryCurrentQuantity;
		this.userID = userID;
		this.ingredientID = ingredientID;
		this.chainID = chainID;
		this.truckID = truckID;
		this.containerID = containerID;
	}

	public String getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(String inventoryID) {
		this.inventoryID = inventoryID;
	}

	public double getInventoryPayment() {
		return inventoryPayment;
	}

	public void setInventoryPayment(double inventoryPayment) {
		this.inventoryPayment = inventoryPayment;
	}

	public LocalDateTime getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(LocalDateTime inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	public LocalDateTime getInventoryExpireDate() {
		return inventoryExpireDate;
	}

	public void setInventoryExpireDate(LocalDateTime inventoryExpireDate) {
		this.inventoryExpireDate = inventoryExpireDate;
	}

	public double getInventoryInitialWeight() {
		return inventoryInitialWeight;
	}

	public void setInventoryInitialWeight(double inventoryInitialWeight) {
		this.inventoryInitialWeight = inventoryInitialWeight;
	}

	public int getInventoryInitialQuantity() {
		return inventoryInitialQuantity;
	}

	public void setInventoryInitialQuantity(int inventoryInitialQuantity) {
		this.inventoryInitialQuantity = inventoryInitialQuantity;
	}

	public double getInventoryCurrentWeight() {
		return inventoryCurrentWeight;
	}

	public void setInventoryCurrentWeight(double inventoryCurrentWeight) {
		this.inventoryCurrentWeight = inventoryCurrentWeight;
	}

	public int getInventoryCurrentQuantity() {
		return inventoryCurrentQuantity;
	}

	public void setInventoryCurrentQuantity(int inventoryCurrentQuantity) {
		this.inventoryCurrentQuantity = inventoryCurrentQuantity;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getIngredientID() {
		return ingredientID;
	}

	public void setIngredientID(String ingredientID) {
		this.ingredientID = ingredientID;
	}

	public String getChainID() {
		return chainID;
	}

	public void setChainID(String chainID) {
		this.chainID = chainID;
	}

	public String getTruckID() {
		return truckID;
	}

	public void setTruckID(String truckID) {
		this.truckID = truckID;
	}

	public String getContainerID() {
		return containerID;
	}

	public void setContainerID(String containerID) {
		this.containerID = containerID;
	}

	@Override
	public String toString() {
		return "InventoryVO [inventoryID=" + inventoryID + ", inventoryPayment=" + inventoryPayment + ", inventoryDate="
				+ inventoryDate + ", inventoryExpireDate=" + inventoryExpireDate + ", inventoryInitialWeight="
				+ inventoryInitialWeight + ", inventoryInitialQuantity=" + inventoryInitialQuantity
				+ ", inventoryCurrentWeight=" + inventoryCurrentWeight + ", inventoryCurrentQuantity="
				+ inventoryCurrentQuantity + ", userID=" + userID + ", ingredientID=" + ingredientID + ", chainID="
				+ chainID + ", truckID=" + truckID + ", containerID=" + containerID + "]";
	}

}
