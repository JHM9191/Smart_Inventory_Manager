package top.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.frame.Biz;
import top.frame.Dao;
import top.vo.IngredientVO;

@Service("ingbiz")
public class IngredientBiz implements Biz<String, IngredientVO> {

	@Resource(name = "ingdao")
	Dao<String, IngredientVO> dao;

	@Override
	public IngredientVO get(String ingID) {
		return dao.select(ingID);
	}

	@Override
	public ArrayList<IngredientVO> get() {
		return dao.selectall();
	}

}