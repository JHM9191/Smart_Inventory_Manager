package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.OrderDetailMapper;
import top.vo.OrderDetailVO;

@Repository("orderdetaildao")
public class OrderDetailDao implements Dao<String, OrderDetailVO> {
	@Autowired
	OrderDetailMapper orderdetailmapper;

	@Override
	public OrderDetailVO select(String orderDetailID) {
		return orderdetailmapper.select(orderDetailID);
	}

	@Override
	public ArrayList<OrderDetailVO> selectall() {
		return orderdetailmapper.selectall();
	}

}