package app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import top.frame.Biz;
import top.vo.ChainVO;
import top.vo.HeadquarterVO;
import top.vo.IngredientVO;
import top.vo.MenuVO;
import top.vo.SalesVO;
import top.vo.UserVO;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		// Headquarter
		Biz<String, HeadquarterVO> hqbiz = (Biz) factory.getBean("hqbiz");
		for (HeadquarterVO hq : hqbiz.get()) {
			System.out.println(hq);
		}

		// User
		Biz<String, UserVO> userbiz = (Biz) factory.getBean("userbiz");
		for (UserVO u : userbiz.get()) {
			System.out.println(u);
		}
		// Tested. Result : OK

		// Ingredient
		Biz<String, IngredientVO> ingbiz = (Biz) factory.getBean("ingbiz");
		for (IngredientVO i : ingbiz.get()) {
			System.out.println(i);
		}
		// Tested. Result : OK

		// Chain
		Biz<String, ChainVO> chainbiz = (Biz) factory.getBean("chainbiz");
		for (ChainVO c : chainbiz.get()) {
			System.out.println(c);
		}
		// Tested. Result : OK

		// Container

		// Order

		// Sales
		Biz<String, SalesVO> salesbiz = (Biz) factory.getBean("salesbiz");
		for (SalesVO s : salesbiz.get()) {
			System.out.println(s);
		}

		// Menu
		Biz<String, MenuVO> menubiz = (Biz) factory.getBean("menubiz");
		for (MenuVO i : menubiz.get()) {
			System.out.println(i);
		}
		// Tested. Result : OK
	}

}
