package top.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.frame.Biz;
import top.frame.Dao;
import top.vo.SalesDetailVO;

@Service("salesdetailbiz")
public class SalesDetailBiz implements Biz<String, SalesDetailVO> {

	@Resource(name = "salesdetaildao")
	Dao<String, SalesDetailVO> dao;

	@Override
	public SalesDetailVO get(String salesDetailID) {
		return dao.select(salesDetailID);
	}

	@Override
	public ArrayList<SalesDetailVO> get() {
		return dao.selectall();
	}

	@Override
	public void register(SalesDetailVO model) {
		dao.insert(model);

	}

	@Override
	public void modify(SalesDetailVO model) {
		dao.update(model);

	}

	@Override
	public void remove(String salesDetailID) {
		dao.delete(salesDetailID);

	}

}