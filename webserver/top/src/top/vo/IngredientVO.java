package top.vo;

import java.time.LocalDateTime;

public class IngredientVO {

	String ingID;
	String ingCategory;
	String ingName;
	double ingPrice;
	String ingUnit;
	String ingBrand;
	String ingredientType;
	double ingWeight;
	LocalDateTime ingRegDate;
	String ingLink;
	int ingLinkCount;
	String ingImgName;

	public IngredientVO() {

	}

	
	public IngredientVO(String ingID, String ingCategory, String ingName, double ingPrice, String ingUnit,
			String ingBrand, String ingredientType, double ingWeight, LocalDateTime ingRegDate, String ingLink,
			int ingLinkCount, String ingImgName) {
		super();
		this.ingID = ingID;
		this.ingCategory = ingCategory;
		this.ingName = ingName;
		this.ingPrice = ingPrice;
		this.ingUnit = ingUnit;
		this.ingBrand = ingBrand;
		this.ingredientType = ingredientType;
		this.ingWeight = ingWeight;
		this.ingRegDate = ingRegDate;
		this.ingLink = ingLink;
		this.ingLinkCount = ingLinkCount;
		this.ingImgName = ingImgName;
	}






	public String getIngID() {
		return ingID;
	}




	public void setIngID(String ingID) {
		this.ingID = ingID;
	}




	public String getIngCategory() {
		return ingCategory;
	}




	public void setIngCategory(String ingCategory) {
		this.ingCategory = ingCategory;
	}




	public String getIngName() {
		return ingName;
	}




	public void setIngName(String ingName) {
		this.ingName = ingName;
	}




	public double getIngPrice() {
		return ingPrice;
	}




	public void setIngPrice(double ingPrice) {
		this.ingPrice = ingPrice;
	}




	public String getIngUnit() {
		return ingUnit;
	}




	public void setIngUnit(String ingUnit) {
		this.ingUnit = ingUnit;
	}




	public String getIngBrand() {
		return ingBrand;
	}




	public void setIngBrand(String ingBrand) {
		this.ingBrand = ingBrand;
	}




	public String getIngredientType() {
		return ingredientType;
	}




	public void setIngredientType(String ingredientType) {
		this.ingredientType = ingredientType;
	}




	public double getIngWeight() {
		return ingWeight;
	}




	public void setIngWeight(double ingWeight) {
		this.ingWeight = ingWeight;
	}




	public LocalDateTime getIngRegDate() {
		return ingRegDate;
	}




	public void setIngRegDate(LocalDateTime ingRegDate) {
		this.ingRegDate = ingRegDate;
	}




	public String getIngLink() {
		return ingLink;
	}




	public void setIngLink(String ingLink) {
		this.ingLink = ingLink;
	}




	public int getIngLinkCount() {
		return ingLinkCount;
	}




	public void setIngLinkCount(int ingLinkCount) {
		this.ingLinkCount = ingLinkCount;
	}




	public String getIngImgName() {
		return ingImgName;
	}




	public void setIngImgName(String ingImgName) {
		this.ingImgName = ingImgName;
	}




	@Override
	public String toString() {
		return "IngredientVO [ingID=" + ingID + ", ingCategory=" + ingCategory + ", ingName=" + ingName + ", ingPrice="
				+ ingPrice + ", ingUnit=" + ingUnit + ", ingBrand=" + ingBrand + ", ingredientType=" + ingredientType
				+ ", ingWeight=" + ingWeight + ", ingRegDate=" + ingRegDate + ", ingLink=" + ingLink + ", ingLinkCount="
				+ ingLinkCount + ", ingImgName=" + ingImgName + "]";
	}

	
}
