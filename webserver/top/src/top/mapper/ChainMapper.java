package top.mapper;

import java.util.ArrayList;

import top.vo.ChainVO;

public interface ChainMapper {

	public ChainVO select(String chainID);

	public ArrayList<ChainVO> selectall();

}