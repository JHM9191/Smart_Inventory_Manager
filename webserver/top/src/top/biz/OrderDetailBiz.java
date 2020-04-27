package top.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.frame.Biz;
import top.frame.Dao;
import top.vo.OrderDetailVO;

@Service("orderdetailbiz")
public class OrderDetailBiz implements Biz<String, OrderDetailVO> {

	@Resource(name = "orderdetaildao")
	Dao<String, OrderDetailVO> dao;

	@Override
	public OrderDetailVO get(String orderDetailID) {
		return dao.select(orderDetailID);
	}

	@Override
	public ArrayList<OrderDetailVO> get() {
		return dao.selectall();
	}

	@Override
	public ArrayList<OrderDetailVO> getlistbyorderid(String id) {
		return dao.selectlistbyorderid(id);
	}

	@Override
	public void register(OrderDetailVO orderdetail) {
		dao.insert(orderdetail);
	}

	@Override
	public void registernew(OrderDetailVO orderdetail) {
		dao.insertnew(orderdetail);
	}

}