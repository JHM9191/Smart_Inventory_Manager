package top.mapper;

import java.util.ArrayList;

import top.vo.OrderVO;

public interface OrderMapper {

	public OrderVO select(String orderID);

	public ArrayList<OrderVO> selectall();

}