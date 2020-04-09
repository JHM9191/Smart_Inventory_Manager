package top.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.frame.Biz;
import top.vo.IngredientVO;

@Controller
public class IngredientController {

	@Resource(name = "ingredientbiz")
	Biz<String, IngredientVO> biz;

	@RequestMapping("/ingredientList")
	public void showIngredientList() {

	}

}
