package top.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.frame.Biz;
import top.frame.Dao;
import top.vo.WarehouseVO;

@Service("wbiz")
public class WarehouseBiz implements Biz<String, WarehouseVO> {

	@Resource(name = "wdao")
	Dao<String, WarehouseVO> dao;

	@Override
	public WarehouseVO get(String id) {
		return dao.select(id);
	}

	@Override
	public ArrayList<WarehouseVO> get() {
		return dao.selectall();
	}

}
