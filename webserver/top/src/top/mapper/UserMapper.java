package top.mapper;

import java.util.ArrayList;

import top.vo.UserVO;

public interface UserMapper {

	public UserVO select(String userID);

	public ArrayList<UserVO> selectall();

	public void insert(UserVO model);

}