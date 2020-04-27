package top.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.frame.Biz;
import top.vo.ContainerVO;
import top.vo.OrderDetailVO;
import top.vo.OrderVO;

@Controller
public class OrderController {

	@Resource(name = "orderbiz")
	Biz<String, OrderVO> orderbiz;
	@Resource(name = "orderdetailbiz")
	Biz<String, OrderDetailVO> orderdetailbiz;

	@Resource(name = "conbiz")
	Biz<String, ContainerVO> conbiz;

	@RequestMapping("/deliverStateCheck.top")
	@ResponseBody
	public String deliverStateCheck(HttpServletRequest req) {
		String chainID = req.getParameter("chainID");
		System.out.println(chainID);

		OrderVO o = new OrderVO();
		o.setChainID(chainID);
//		String deliveryDate = LocalDateTime.now().minus(1, ChronoUnit.DAYS)
//				.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		String deliveryDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		System.out.println("deliveryDate : " + deliveryDate);
		o.setDeliveryDate(deliveryDate);

		OrderVO order = orderbiz.getorderbychain(o);
		System.out.println("order : " + order);

		if (order.getDeliveryState().equals("ondelivery")) {
			return "ondelivery";
		} else {
			return "unidentified";
		}

	}

	@RequestMapping("/senddelivercomplete.top")
	@ResponseBody
	public String senddelivercomplete(HttpServletRequest res) {
		String orderID = res.getParameter("orderID");
		System.out.println(orderID);

		OrderVO order_db = orderbiz.getbyorderid(orderID);
		System.out.println("order from db : " + order_db);

		String chainID = order_db.getChainID();
		ArrayList<ContainerVO> conList = conbiz.getForChain(chainID);
		ArrayList<OrderDetailVO> odList = orderdetailbiz.getlistbyorderid(orderID);
		for (int i = 0; i < conList.size(); i++) {
			String conID_from_con = conList.get(i).getConID();
			double ingWeight = conList.get(i).getIngWeight();
			System.out.println("conID_from_con : " + conID_from_con);
			for (int j = 0; j < odList.size(); j++) {
				System.out.println("odList.get(j).getConID() : " + odList.get(j).getConID());
				if (conID_from_con.equals(odList.get(j).getConID())) {
					int ingQuantity = odList.get(j).getIngQuantity();
					double totWeight = odList.get(j).getTotWeight();
					double conFullWeight = ingQuantity * ingWeight;
					double conCurrWeight = conFullWeight;
					int conFullQuantity = ingQuantity;
					int conCurrQuantity = ingQuantity;
					String ingID = odList.get(j).getIngID();
					String ingName = odList.get(j).getIngName();
					int ingPrice = odList.get(j).getIngPrice();
					conList.get(i).setConFullWeight(conFullWeight);
					conList.get(i).setConCurrWeight(conCurrWeight);
					conList.get(i).setConFullQuantity(conFullQuantity);
					conList.get(i).setConCurrQuantity(conCurrQuantity);
					conbiz.modifyondelivered(conList.get(i));
				}
			}
		}
		order_db.setDeliveryState("delivered");
		orderbiz.modify(order_db);
		return "1";
	}
}
