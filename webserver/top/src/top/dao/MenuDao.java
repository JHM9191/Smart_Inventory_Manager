package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.MenuMapper;
import top.vo.MenuVO;

@Repository("menudao")
public class MenuDao implements Dao<String, MenuVO> {
	@Autowired
	MenuMapper menumapper;

	@Override
	public MenuVO select(String mneuID) {
		return menumapper.select(mneuID);
	}

	@Override
	public ArrayList<MenuVO> selectall() {
		return menumapper.selectall();
	}

}