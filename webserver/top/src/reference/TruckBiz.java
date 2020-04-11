package reference;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.frame.Biz;
import top.frame.Dao;

@Service("truckbiz")
public class TruckBiz implements Biz<String, TruckVO> {

	@Resource(name = "truckdao")
	Dao<String, TruckVO> dao;
	
	@Override
	public TruckVO get(String id) {
		return dao.select(id);
	}

	@Override
	public ArrayList<TruckVO> get() {
		return dao.selectall();
	}
	
	
	


}