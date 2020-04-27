package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.UserMapper;
import top.vo.UserVO;

@Repository("userdao")
public class UserDao implements Dao<String, UserVO> {
	@Autowired
	UserMapper usermapper;
	
	

	@Override
	public UserVO select(String userID) {
		return usermapper.select(userID);
	}

	@Override
	public ArrayList<UserVO> selectall() {
		return usermapper.selectall();
	}
	
	@Override
	public void insert(UserVO model) {
		usermapper.insert(model);
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserVO model) {
		// TODO Auto-generated method stub
		
	}





}