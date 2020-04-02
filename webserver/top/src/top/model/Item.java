package top.model;

import java.util.Date;

public class Item {

	String id;
	String code;
	String name;
	String category;
	Date regDate;
	Date expireDate;

	public Item() {

	}

	public Item(String id, String code, String name, String category, Date regDate, Date expireDate) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.category = category;
		this.regDate = regDate;
		this.expireDate = expireDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", code=" + code + ", name=" + name + ", category=" + category + ", regDate="
				+ regDate + ", expireDate=" + expireDate + "]";
	}

}
