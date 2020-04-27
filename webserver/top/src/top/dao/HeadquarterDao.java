package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.HeadquarterMapper;
import top.vo.HeadquarterVO;

@Repository("hqdao")
public class HeadquarterDao implements Dao<String, HeadquarterVO> {
	@Autowired
	HeadquarterMapper hqmapper;

	@Override
	public HeadquarterVO select(String hqID) {
		return hqmapper.select(hqID);
	}

	@Override
	public ArrayList<HeadquarterVO> selectall() {
		return hqmapper.selectall();
	}

	@Override
	public void insert(HeadquarterVO model) {
		hqmapper.insert(model);

	}

	@Override
	public void update(HeadquarterVO model) {
		hqmapper.update(model);

	}

	///// used END !/////

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}