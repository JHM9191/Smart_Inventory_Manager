package app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import top.frame.Biz;
import top.vo.IngredientVO;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, IngredientVO> biz = (Biz) factory.getBean("ingredientbiz");

	}

}
