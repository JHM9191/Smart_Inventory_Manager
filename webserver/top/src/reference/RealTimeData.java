package reference;

public class RealTimeData {

	String wh_ID;
	String item_code;
	String item_name;
	int item_quantity;
	double remaining;

	public RealTimeData() {

	}

	public RealTimeData(String wh_ID, String item_code, String item_name, int item_quantity, double remaining) {
		super();
		this.wh_ID = wh_ID;
		this.item_code = item_code;
		this.item_name = item_name;
		this.item_quantity = item_quantity;
		this.remaining = remaining;
	}

	public String getWh_ID() {
		return wh_ID;
	}

	public void setWh_ID(String wh_ID) {
		this.wh_ID = wh_ID;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	public double getRemaining() {
		return remaining;
	}

	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}

	@Override
	public String toString() {
		return "RealTimeData [wh_ID=" + wh_ID + ", item_code=" + item_code + ", item_name=" + item_name
				+ ", item_quantity=" + item_quantity + ", remaining=" + remaining + "]";
	}

}
