package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.UserMapper;
import top.vo.User;


@Repository("udao")
public class UserDao implements Dao<String, User > {
	@Autowired
	UserMapper um;
	
	// Login ÇÒ¶§ 
	@Override
	public User select(String u_id) {
		
		return um.select(u_id);
	}

	@Override
	public ArrayList<User> selectall() {
		return um.selectall();
	}
	
	
	
}