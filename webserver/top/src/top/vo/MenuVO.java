package top.vo;

public class MenuVO {

	String menuID;
	String menuName;
	int menuPrice;

	public MenuVO() {

	}

	public MenuVO(String menuID, String menuName, int menuPrice) {
		super();
		this.menuID = menuID;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}

	public String getMenuID() {
		return menuID;
	}

	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	@Override
	public String toString() {
		return "MenuVO [menuID=" + menuID + ", menuName=" + menuName + ", menuPrice=" + menuPrice + "]";
	}

}
