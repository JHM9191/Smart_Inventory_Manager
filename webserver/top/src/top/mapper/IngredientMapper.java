package top.mapper;

import java.util.ArrayList;

import top.vo.IngredientVO;

public interface IngredientMapper {

	public IngredientVO select(String ingID);

	public ArrayList<IngredientVO> selectall();

}