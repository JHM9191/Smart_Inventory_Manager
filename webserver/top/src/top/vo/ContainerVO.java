package top.vo;

public class ContainerVO {

	String containerID;
	String containerSize;
	double continerMaxWeight;
	double containerFull;
	double containerWarning;
	String userID;
	String chainID;

	public ContainerVO() {

	}

	public ContainerVO(String containerID, String containerSize, double continerMaxWeight, double containerFull,
			double containerWarning, String userID, String chainID) {
		super();
		this.containerID = containerID;
		this.containerSize = containerSize;
		this.continerMaxWeight = continerMaxWeight;
		this.containerFull = containerFull;
		this.containerWarning = containerWarning;
		this.userID = userID;
		this.chainID = chainID;
	}

	public String getContainerID() {
		return containerID;
	}

	public void setContainerID(String containerID) {
		this.containerID = containerID;
	}

	public String getContainerSize() {
		return containerSize;
	}

	public void setContainerSize(String containerSize) {
		this.containerSize = containerSize;
	}

	public double getContinerMaxWeight() {
		return continerMaxWeight;
	}

	public void setContinerMaxWeight(double continerMaxWeight) {
		this.continerMaxWeight = continerMaxWeight;
	}

	public double getContainerFull() {
		return containerFull;
	}

	public void setContainerFull(double containerFull) {
		this.containerFull = containerFull;
	}

	public double getContainerWarning() {
		return containerWarning;
	}

	public void setContainerWarning(double containerWarning) {
		this.containerWarning = containerWarning;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getChainID() {
		return chainID;
	}

	public void setChainID(String chainID) {
		this.chainID = chainID;
	}

	@Override
	public String toString() {
		return "ContainerVO [containerID=" + containerID + ", containerSize=" + containerSize + ", continerMaxWeight="
				+ continerMaxWeight + ", containerFull=" + containerFull + ", containerWarning=" + containerWarning
				+ ", userID=" + userID + ", chainID=" + chainID + "]";
	}

}
