package app.container;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import top.frame.Biz;
import top.vo.ContainerVO;

public class containerSelectAll {

	@Autowired
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, ContainerVO> biz = (Biz<String, ContainerVO>) factory.getBean("conbiz");

		ArrayList <ContainerVO> container;
		
		try {
			container = biz.get();
			for(ContainerVO i : container) {
				System.out.println(i);
			}
			System.out.println("container selectAll Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
