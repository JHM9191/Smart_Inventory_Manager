package top.mapper;

import java.util.ArrayList;

import top.vo.SalesDetailVO;

public interface SalesDetailMapper {

	public SalesDetailVO select(String salesDetailID);

	public ArrayList<SalesDetailVO> selectall();
	
	public void insert(SalesDetailVO model);
	
	public void update(SalesDetailVO model);
	
	public void delete(String salesDetailID);
	

}