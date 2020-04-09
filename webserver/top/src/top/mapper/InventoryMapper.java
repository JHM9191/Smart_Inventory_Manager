package top.mapper;

import java.util.ArrayList;

import top.vo.InventoryVO;

public interface InventoryMapper {

	public InventoryVO select(String inventoryID);

	public ArrayList<InventoryVO> selectall();

}