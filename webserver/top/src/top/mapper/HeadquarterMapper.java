package top.mapper;

import java.util.ArrayList;

import top.vo.HeadquarterVO;

public interface HeadquarterMapper {

	public HeadquarterVO select(String hqID);

	public ArrayList<HeadquarterVO> selectall();

}