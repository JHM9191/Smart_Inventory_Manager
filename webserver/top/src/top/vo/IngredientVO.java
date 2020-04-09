package top.vo;

import java.time.LocalDateTime;

public class IngredientVO {

	String ingredientID;
	String ingredientCode;
	String ingredientName;
	double ingredientPrice;
	String ingredientUnit;
	String ingredientBrand;
	String ingredientCategory;
	String ingredientType;
	double ingredientWeight;
	LocalDateTime ingredientRegDate;
	String ingredientPurchaseLink;
	int ingredientPurchaseCount;
	String ingredientImageName;

	public IngredientVO() {

	}

	public IngredientVO(String ingredientID, String ingredientCode, String ingredientName, double ingredientPrice,
			String ingredientUnit, String ingredientBrand, String ingredientCategory, String ingredientType,
			double ingredientWeight, LocalDateTime ingredientRegDate, String ingredientPurchaseLink,
			int ingredientPurchaseCount, String ingredientImageName) {
		super();
		this.ingredientID = ingredientID;
		this.ingredientCode = ingredientCode;
		this.ingredientName = ingredientName;
		this.ingredientPrice = ingredientPrice;
		this.ingredientUnit = ingredientUnit;
		this.ingredientBrand = ingredientBrand;
		this.ingredientCategory = ingredientCategory;
		this.ingredientType = ingredientType;
		this.ingredientWeight = ingredientWeight;
		this.ingredientRegDate = ingredientRegDate;
		this.ingredientPurchaseLink = ingredientPurchaseLink;
		this.ingredientPurchaseCount = ingredientPurchaseCount;
		this.ingredientImageName = ingredientImageName;
	}

	public String getIngredientID() {
		return ingredientID;
	}

	public void setIngredientID(String ingredientID) {
		this.ingredientID = ingredientID;
	}

	public String getIngredientCode() {
		return ingredientCode;
	}

	public void setIngredientCode(String ingredientCode) {
		this.ingredientCode = ingredientCode;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public double getIngredientPrice() {
		return ingredientPrice;
	}

	public void setIngredientPrice(double ingredientPrice) {
		this.ingredientPrice = ingredientPrice;
	}

	public String getIngredientUnit() {
		return ingredientUnit;
	}

	public void setIngredientUnit(String ingredientUnit) {
		this.ingredientUnit = ingredientUnit;
	}

	public String getIngredientBrand() {
		return ingredientBrand;
	}

	public void setIngredientBrand(String ingredientBrand) {
		this.ingredientBrand = ingredientBrand;
	}

	public String getIngredientCategory() {
		return ingredientCategory;
	}

	public void setIngredientCategory(String ingredientCategory) {
		this.ingredientCategory = ingredientCategory;
	}

	public String getIngredientType() {
		return ingredientType;
	}

	public void setIngredientType(String ingredientType) {
		this.ingredientType = ingredientType;
	}

	public double getIngredientWeight() {
		return ingredientWeight;
	}

	public void setIngredientWeight(double ingredientWeight) {
		this.ingredientWeight = ingredientWeight;
	}

	public LocalDateTime getIngredientRegDate() {
		return ingredientRegDate;
	}

	public void setIngredientRegDate(LocalDateTime ingredientRegDate) {
		this.ingredientRegDate = ingredientRegDate;
	}

	public String getIngredientPurchaseLink() {
		return ingredientPurchaseLink;
	}

	public void setIngredientPurchaseLink(String ingredientPurchaseLink) {
		this.ingredientPurchaseLink = ingredientPurchaseLink;
	}

	public int getIngredientPurchaseCount() {
		return ingredientPurchaseCount;
	}

	public void setIngredientPurchaseCount(int ingredientPurchaseCount) {
		this.ingredientPurchaseCount = ingredientPurchaseCount;
	}

	public String getIngredientImageName() {
		return ingredientImageName;
	}

	public void setIngredientImageName(String ingredientImageName) {
		this.ingredientImageName = ingredientImageName;
	}

	@Override
	public String toString() {
		return "IngredientVO [ingredientID=" + ingredientID + ", ingredientCode=" + ingredientCode + ", ingredientName="
				+ ingredientName + ", ingredientPrice=" + ingredientPrice + ", ingredientUnit=" + ingredientUnit
				+ ", ingredientBrand=" + ingredientBrand + ", ingredientCategory=" + ingredientCategory
				+ ", ingredientType=" + ingredientType + ", ingredientWeight=" + ingredientWeight
				+ ", ingredientRegDate=" + ingredientRegDate + ", ingredientPurchaseLink=" + ingredientPurchaseLink
				+ ", ingredientPurchaseCount=" + ingredientPurchaseCount + ", ingredientImageName="
				+ ingredientImageName + "]";
	}

}
