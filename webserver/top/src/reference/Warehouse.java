package reference;

import java.util.ArrayList;

public class Warehouse {

	String ID;
	String name;
	String address;
	ArrayList<Container> containerList;

	public Warehouse() {

	}

	public Warehouse(String iD, String name, String address, ArrayList<Container> containerList) {
		super();
		ID = iD;
		this.name = name;
		this.address = address;
		this.containerList = containerList;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Container> getContainerList() {
		return containerList;
	}

	public void setContainerList(ArrayList<Container> containerList) {
		this.containerList = containerList;
	}

	@Override
	public String toString() {
		return "Warehouse [ID=" + ID + ", name=" + name + ", address=" + address + ", containerList=" + containerList
				+ "]";
	}

}
