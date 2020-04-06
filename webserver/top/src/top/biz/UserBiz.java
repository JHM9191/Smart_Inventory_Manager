package top.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.frame.Biz;
import top.frame.Dao;
import top.vo.User;

@Service("ubiz")
public class UserBiz implements Biz<String, User> {

	@Resource(name = "udao")
	Dao<String, User> dao;
	
	@Override
	public User get(String u_id) {
		return dao.select(u_id);
	}

	@Override
	public ArrayList<User> get() {
		return dao.selectall();
	}
	
	
	


}