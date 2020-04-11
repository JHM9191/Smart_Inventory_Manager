package reference;

import java.util.ArrayList;

public interface InventoryMapper {

	public InventoryVO select(String inventoryID);

	public ArrayList<InventoryVO> selectall();

}