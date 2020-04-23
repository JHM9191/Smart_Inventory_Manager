package top.vo;

public class ConRegiVO {

	String size;
	String ingName;
	String ingID;
	int quantity;
	int warning;
	String chainID;
	String chainName;

	public ConRegiVO() {

	}

	public ConRegiVO(String size, String ingName, String ingID, int quantity, int warning, String chainID,
			String chainName) {
		super();
		this.size = size;
		this.ingName = ingName;
		this.ingID = ingID;
		this.quantity = quantity;
		this.warning = warning;
		this.chainID = chainID;
		this.chainName = chainName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getIngName() {
		return ingName;
	}

	public void setIngName(String ingName) {
		this.ingName = ingName;
	}

	public String getIngID() {
		return ingID;
	}

	public void setIngID(String ingID) {
		this.ingID = ingID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getWarning() {
		return warning;
	}

	public void setWarning(int warning) {
		this.warning = warning;
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

	@Override
	public String toString() {
		return "ConRegiVO [size=" + size + ", ingName=" + ingName + ", ingID=" + ingID + ", quantity=" + quantity
				+ ", warning=" + warning + ", chainID=" + chainID + ", chainName=" + chainName + "]";
	}

}
