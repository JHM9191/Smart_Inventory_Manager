package reference;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.frame.Biz;
import top.frame.Dao;

@Service("inventorybiz")
public class InventoryBiz implements Biz<String, InventoryVO> {

	@Resource(name = "inventorydao")
	Dao<String, InventoryVO> dao;
	
	@Override
	public InventoryVO get(String id) {
		return dao.select(id);
	}

	@Override
	public ArrayList<InventoryVO> get() {
		return dao.selectall();
	}
	
	
	


}