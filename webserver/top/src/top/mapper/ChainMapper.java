package top.mapper;

import java.util.ArrayList;

import top.vo.ChainVO;

public interface ChainMapper {

	public ChainVO select(String chainID);

	public ArrayList<ChainVO> selectall();

	public ArrayList<ChainVO> selectbyhq(String hqID);

	// user cnt apply.top 일때 사용
	public ChainVO selectchainname(String chainid);

	// hq가 맡은 chain을 모두 불러오기 위해서
	public ArrayList<ChainVO> selectnotifi(String hqid);

	// addAddrimpl.top
	public void insert(ChainVO chainvo);

}