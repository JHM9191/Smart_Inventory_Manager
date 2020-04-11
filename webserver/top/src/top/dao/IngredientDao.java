package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.IngredientMapper;
import top.vo.IngredientVO;

@Repository("ingdao")
public class IngredientDao implements Dao<String, IngredientVO> {
	@Autowired
	IngredientMapper ingredientmapper;

	@Override
	public IngredientVO select(String ingID) {
		return ingredientmapper.select(ingID);
	}

	@Override
	public ArrayList<IngredientVO> selectall() {
		return ingredientmapper.selectall();
	}

}