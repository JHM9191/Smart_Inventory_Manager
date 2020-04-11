package top.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.frame.Biz;
import top.frame.Dao;
import top.vo.HeadquarterVO;

@Service("hqbiz")
public class HeadquarterBiz implements Biz<String, HeadquarterVO> {

	@Resource(name = "hqdao")
	Dao<String, HeadquarterVO> dao;
	
	@Override
	public HeadquarterVO get(String hqID) {
		return dao.select(hqID);
	}

	@Override
	public ArrayList<HeadquarterVO> get() {
		return dao.selectall();
	}
	
	
	


}