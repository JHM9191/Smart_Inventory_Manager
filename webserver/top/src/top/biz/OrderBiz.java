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
	public OrderVO get(String orderID) {
		return dao.select(orderID);
	}

	@Override
	public ArrayList<OrderVO> get() {
		return dao.selectall();
	}

}