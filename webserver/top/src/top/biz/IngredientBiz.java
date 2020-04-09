package top.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.frame.Biz;
import top.frame.Dao;
import top.vo.IngredientVO;

@Service("ingredientbiz")
public class IngredientBiz implements Biz<String, IngredientVO> {

	@Resource(name = "ingredientdao")
	Dao<String, IngredientVO> dao;

	@Override
	public IngredientVO get(String id) {
		return dao.select(id);
	}

	@Override
	public ArrayList<IngredientVO> get() {
		return dao.selectall();
	}

}