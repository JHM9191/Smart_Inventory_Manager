package top.mapper;

import java.util.ArrayList;

import top.vo.TruckVO;

public interface TruckMapper {

	public TruckVO select(String truckID);

	public ArrayList<TruckVO> selectall();

}