package top.vo;

import java.util.ArrayList;

public class User {
	
	
	String u_id;
	String u_pwd;
	String u_name;
	String u_phone;
	ArrayList<String> u_addr;
	
	public User() {
		super();
	}

	public User(String u_id, String u_pwd, String u_name, String u_phone, ArrayList<String> u_addr) {
		super();
		this.u_id = u_id;
		this.u_pwd = u_pwd;
		this.u_name = u_name;
		this.u_phone = u_phone;
		this.u_addr = u_addr;
	}

	
	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public ArrayList<String> getU_addr() {
		return u_addr;
	}

	public void setU_addr(ArrayList<String> u_addr) {
		this.u_addr = u_addr;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_pwd=" + u_pwd + ", u_name=" + u_name + ", u_phone=" + u_phone + ", u_addr="
				+ u_addr + "]";
	}
	




}
