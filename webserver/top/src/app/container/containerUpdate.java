package app.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import top.frame.Biz;
import top.vo.ContainerVO;

public class containerUpdate {

	@Autowired
	public static void main(String[] args) {
		/*
		 * <update id = "update" parameterType="container"> UPADATE CONTAINER SET
		 * CONWARINGWEIGHT=#{conWarningWeight},CONWARNINGQUANTITY=#{conWarningQuantity},
		 * CONUNITWEIGHT=#{conUnitWeight} WHERE CONID = #{conID}
		 * 
		 */

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, ContainerVO> biz = (Biz<String, ContainerVO>) factory.getBean("conbiz");

		ContainerVO container = new ContainerVO();

		container.setConWarningWeight(20.00);
		container.setConWarningQuantity(10);
		container.setConUnitWeight(4.00);
		container.setConID("1000014");

		System.out.println(container.toString());

		try {
			biz.modify(container);
			System.out.println("container modify Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
