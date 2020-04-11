package reference;

import java.time.LocalDateTime;
import java.util.Date;

public class Item {

	String id;
	String code;
	String name;
	String category;
	String state;
	LocalDateTime regDate;
	LocalDateTime expireDate;

	public Item() {

	}

	public Item(String id, String code, String name, String category, String state, LocalDateTime regDate, LocalDateTime expireDate) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.category = category;
		this.state = state;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDateTime expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", code=" + code + ", name=" + name + ", category=" + category + ", state=" + state
				+ ", regDate=" + regDate + ", expireDate=" + expireDate + "]";
	}

}
