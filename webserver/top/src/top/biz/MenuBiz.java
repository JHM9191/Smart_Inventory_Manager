package top.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.frame.Biz;
import top.frame.Dao;
import top.vo.MenuVO;

@Service("menubiz")
public class MenuBiz implements Biz<String, MenuVO> {

	@Resource(name = "menudao")
	Dao<String, MenuVO> dao;

	@Override
	public MenuVO get(String menuID) {
		return dao.select(menuID);
	}

	@Override
	public ArrayList<MenuVO> get() {
		return dao.selectall();
	}

}