package top.mapper;

import java.util.ArrayList;

import top.vo.WarehouseVO;

public interface WarehouseMapper {
	
	public WarehouseVO select(String warehouse_ID);
	
	public ArrayList<WarehouseVO> selectall();

}
