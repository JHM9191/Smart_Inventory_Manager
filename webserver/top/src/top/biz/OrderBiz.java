package top.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.frame.Biz;
import top.frame.Dao;
import top.vo.OrderVO;

@Service("orderbiz")
public class OrderBiz implements Biz<String, OrderVO> {

	@Resource(name = "orderdao")
	Dao<String, OrderVO> dao;

	@Override
	public void register(OrderVO order) {
		dao.insert(order);
	}

	@Override
	public void registertoday(OrderVO order) {
		dao.inserttoday(order);
	}

	@Override
	public OrderVO get(String orderID) {
		return dao.select(orderID);
	}

	@Override
	public ArrayList<OrderVO> get() {
		return dao.selectall();
	}

	@Override
	public OrderVO getorderbychain(OrderVO order) {
		return dao.selectorderbychain(order);
	}

	@Override
	public OrderVO getbyorderid(String orderID) {
		return dao.selectbyorderid(orderID);
	}

	@Override
	public OrderVO getordertoday(OrderVO order) {
		return dao.selectordertoday(order);
	}
}