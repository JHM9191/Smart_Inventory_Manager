package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.OrderMapper;
import top.vo.OrderVO;

@Repository("orderdao")
public class OrderDao implements Dao<String, OrderVO> {
	@Autowired
	OrderMapper ordermapper;

	@Override
	public void insert(OrderVO order) {
		ordermapper.insert(order);
	}

	@Override
	public void inserttoday(OrderVO order) {
		ordermapper.inserttoday(order);
	}

	@Override
	public OrderVO select(String orderID) {
		return ordermapper.select(orderID);
	}

	@Override
	public ArrayList<OrderVO> selectall() {
		return ordermapper.selectall();
	}

	@Override
	public OrderVO selectorderbychain(OrderVO order) {
		return ordermapper.selectorderbychain(order);
	}

	@Override
	public OrderVO selectbyorderid(String id) {
		return ordermapper.selectbyorderid(id);
	}

	@Override
	public OrderVO selectordertoday(OrderVO order) {
		return ordermapper.selectordertoday(order);
	}
}