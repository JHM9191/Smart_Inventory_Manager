package top.mapper;

import java.util.ArrayList;

import top.vo.SalesVO;

public interface SalesMapper {

	public SalesVO select(String salesID);

	public ArrayList<SalesVO> selectall();

}