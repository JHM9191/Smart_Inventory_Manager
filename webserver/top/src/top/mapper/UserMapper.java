package top.mapper;

import java.util.ArrayList;

import top.vo.User;

public interface UserMapper {

	public User select(String u_id);

	public ArrayList<User> selectall();

}