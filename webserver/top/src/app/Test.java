package app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import top.frame.Biz;
import top.vo.IngredientVO;
import top.vo.MenuVO;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		// Headquarter

		// User

		// Ingredient
		Biz<String, IngredientVO> ingbiz = (Biz) factory.getBean("ingbiz");
		for (IngredientVO i : ingbiz.get()) {
			System.out.println(i);
		}
		// Tested. Result : OK

		// Chain

		// Container

		// Order

		// Sales

		// Menu
		Biz<String, MenuVO> menubiz = (Biz) factory.getBean("menubiz");
		for (MenuVO i : menubiz.get()) {
			System.out.println(i);
		}
		// Tested. Result : OK
	}

}
