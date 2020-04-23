package top.vo;

public class ContainerVO {

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
	String chainID;
	String chainName;
	String hqID;
	String hqName;

	public ContainerVO() {
		super();
	}

	public ContainerVO(String conID, String conSize, double conMaxWeight, String conRegDate, String conUpdateDate,
			double conFullWeight, int conFullQuantity, double conWarningWeight, int conWarningQuantity,
			double conCurrWeight, int conCurrQuantity, double conUnitWeight, String ingID, String ingName,
			String chainID, String chainName, String hqID, String hqName) {
		super();
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
		this.chainID = chainID;
		this.chainName = chainName;
		this.hqID = hqID;
		this.hqName = hqName;
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

	@Override
	public String toString() {
		return "ContainerVO [conID=" + conID + ", conSize=" + conSize + ", conMaxWeight=" + conMaxWeight
				+ ", conRegDate=" + conRegDate + ", conUpdateDate=" + conUpdateDate + ", conFullWeight=" + conFullWeight
				+ ", conFullQuantity=" + conFullQuantity + ", conWarningWeight=" + conWarningWeight
				+ ", conWarningQuantity=" + conWarningQuantity + ", conCurrWeight=" + conCurrWeight
				+ ", conCurrQuantity=" + conCurrQuantity + ", conUnitWeight=" + conUnitWeight + ", ingID=" + ingID
				+ ", ingName=" + ingName + ", chainID=" + chainID + ", chainName=" + chainName + ", hqID=" + hqID
				+ ", hqName=" + hqName + "]";
	}

}
