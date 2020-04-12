package top.mapper;

import java.util.ArrayList;

import top.vo.MenuVO;

public interface MenuMapper {

	public MenuVO select(String menuID);

	public ArrayList<MenuVO> selectall();

}