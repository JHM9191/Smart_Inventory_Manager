package top.mapper;

import java.util.ArrayList;

import top.vo.NotiVO;

public interface NotiMapper {

	public void insert(NotiVO notivo);

	// hq가 맡는 각각의 chainId에 해당하는 noti를 모두 불러온다
	public NotiVO select(String chainID);

	// refresh 상태가 바뀌는 것!
	public void updaterefresh(String chainID);

	public ArrayList<NotiVO> selectall();

}
