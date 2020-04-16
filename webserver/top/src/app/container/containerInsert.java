package app.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import top.frame.Biz;
import top.vo.ContainerVO;

public class containerInsert {

	@Autowired
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, ContainerVO> biz = (Biz<String, ContainerVO>) factory.getBean("conbiz");

		ContainerVO container = new ContainerVO();
		container.setConID("chainId");
		container.setConSize("500");
		container.setConMaxWeight(50.00);
		container.setConFullWeight(40.00);
		container.setConFullQuantity(20);
		container.setConWarningWeight(20.00);
		container.setConWarningQuantity(5); 
		container.setConCurrWeight(10.00);
		container.setConCurrQuantity(5);
		container.setConUnitWeight(1.00);
		container.setIngID("ingID_1000000");
		container.setChainID("chainID_1000000");
		
		System.out.println(container.toString());


		try {
			biz.register(container);
			System.out.println("container Register Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
