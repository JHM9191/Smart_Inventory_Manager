package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.WarehouseMapper;
import top.vo.WarehouseVO;

@Repository("wdao")
public class WarehouseDao implements Dao<String, WarehouseVO> {

	@Autowired
	WarehouseMapper wm;

	@Override
	public WarehouseVO select(String id) {

		return wm.select(id);
	}

	@Override
	public ArrayList<WarehouseVO> selectall() {
		return wm.selectall();
	}

}
