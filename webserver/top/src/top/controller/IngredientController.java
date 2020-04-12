package top.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import top.frame.Biz;
import top.vo.IngredientVO;

@Controller
public class IngredientController {

	@Resource(name = "ingbiz")
	Biz<String, IngredientVO> biz;

	
	
	// Show ingredient list
	@RequestMapping("/ingredientList.top")
	public ModelAndView showIngredientList(ModelAndView mv, HttpServletResponse res) {

		for (IngredientVO i : biz.get()) {
			System.out.println(i);
		}
		
		
		mv.addObject("loginId", "dd");
		mv.addObject("ingredientListData", biz.get());
		mv.addObject("ingredientListTable", "../ingredient/ingredientList");
		mv.setViewName("main/main");
		res.setContentType("text/html; charset=UTF-8");

		return mv;
	}
	
	// Add ingredient
	
	
	
	// Modify ingredient
	
	
	
	// delete ingredient
	

}
