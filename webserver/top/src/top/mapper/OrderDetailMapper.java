package top.mapper;

import java.util.ArrayList;

import top.vo.OrderDetailVO;

public interface OrderDetailMapper {

	public OrderDetailVO select(String orderDetailID);

	public ArrayList<OrderDetailVO> selectall();

	public ArrayList<OrderDetailVO> selectlistbyorderid(String orderID);

	public void insert(OrderDetailVO orderdetail);

	public void insertnew(OrderDetailVO orderdetail);

}