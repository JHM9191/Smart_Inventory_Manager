package top.mapper;

import java.util.ArrayList;

import top.vo.OrderVO;

public interface OrderMapper {

	public void insert(OrderVO order);

	public void inserttoday(OrderVO order);

	public OrderVO select(String orderID);

	public ArrayList<OrderVO> selectall();

	public OrderVO selectorderbychain(OrderVO order);

	public OrderVO selectbyorderid(String orderID);

	public OrderVO selectordertoday(OrderVO order);

}