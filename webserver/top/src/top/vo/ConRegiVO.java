package top.vo;

public class ConRegiVO {

	String size;
	String ing;
	String ingID;
	int quantity;
	int warning;
	String chainID;

	public ConRegiVO() {

	}

	public ConRegiVO(String size, String ing, String ingID, int quantity, int warning, String chainID) {
		super();
		this.size = size;
		this.ing = ing;
		this.ingID = ingID;
		this.quantity = quantity;
		this.warning = warning;
		this.chainID = chainID;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getIng() {
		return ing;
	}

	public void setIng(String ing) {
		this.ing = ing;
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

	@Override
	public String toString() {
		return "ConRegiVO [size=" + size + ", ing=" + ing + ", ingID=" + ingID + ", quantity=" + quantity + ", warning="
				+ warning + ", chainID=" + chainID + "]";
	}

}
