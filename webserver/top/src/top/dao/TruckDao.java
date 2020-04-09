package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.TruckMapper;
import top.vo.TruckVO;

@Repository("truckdao")
public class TruckDao implements Dao<String, TruckVO> {
	@Autowired
	TruckMapper truckmapper;

	@Override
	public TruckVO select(String truckID) {
		return truckmapper.select(truckID);
	}

	@Override
	public ArrayList<TruckVO> selectall() {
		return truckmapper.selectall();
	}

}