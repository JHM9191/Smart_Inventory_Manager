package app.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import top.frame.Biz;
import top.vo.ContainerVO;


/*
 * 	SELECT * FROM CONTAINER WHERE conID=#{conID}
 */

public class containerSelect {

	@Autowired
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, ContainerVO> biz = (Biz<String, ContainerVO>) factory.getBean("conbiz");

		ContainerVO container = new ContainerVO();

		try {
			container = biz.get("CONID_1000000");
			System.out.println(container);
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
