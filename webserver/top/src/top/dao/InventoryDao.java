package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.InventoryMapper;
import top.vo.InventoryVO;

@Repository("inventorydao")
public class InventoryDao implements Dao<String, InventoryVO> {
	@Autowired
	InventoryMapper inventorymapper;

	@Override
	public InventoryVO select(String inventoryID) {
		return inventorymapper.select(inventoryID);
	}

	@Override
	public ArrayList<InventoryVO> selectall() {
		return inventorymapper.selectall();
	}

}