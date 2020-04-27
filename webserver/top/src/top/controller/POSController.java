package top.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.frame.Biz;
import top.vo.SalesDetailVO;
import top.vo.SalesVO;

@Controller
public class POSController {

	@Resource(name = "salesbiz")
	Biz<String, SalesVO> salesbiz;

	@Resource(name = "salesdetailbiz")
	Biz<String, SalesDetailVO> salesdetailbiz;

	SalesDetailVO sd;
	SalesVO sales;

	String regdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

	// 안드로이드 POS 에서 오는 JSON 받기 //
	@RequestMapping(value = "/pos.top", method = RequestMethod.POST)
	@ResponseBody
	public String getData(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jo) {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println("getData From Sales. Android. ---Start");

		System.out.println(jo);

		Map sjo = (Map) (jo.get("jsonData"));

		String saleDate = (String) sjo.get("saleDate");
		int saleCount = (int) sjo.get("saleCount");
		int saleCost = (int) sjo.get("saleCost");
		String saleAdmin = (String) sjo.get("saleAdmin");

		System.out.println("saleData: " + saleDate + " saleCount: " + saleCount + " saleCost :" + saleCost
				+ " saleAdmin :" + saleAdmin);

		String temp = request.getParameter("jsonData");

		ArrayList<SalesVO> slist = new ArrayList<SalesVO>();

		String result = "success";

		return result;
	}

	@RequestMapping(value = "/posorder.top", method = RequestMethod.POST)
	@ResponseBody
	public String orderData(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jo) {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		System.out.println("getOrderData From Android. ---Start");

		System.out.println("getJsondata:" + jo);

		Map sjo = (Map) (jo.get("jsonData"));

		String orderDate = (String) sjo.get("orderDate");
		int orderCount = (int) sjo.get("orderCount");
		int orderCost = (int) sjo.get("orderCost");
		String orderNo = (String) sjo.get("orderNO");
		String chainID = (String) sjo.get("chainID");

		System.out.println("chainID : " + chainID);
		sales = new SalesVO();

//		sales = salesbiz.getbychain(chainID);
		// orderNo 로 넣어도 Sequence 로적용된다. -> SalesDetail 에 어떻게 SaelsID를 넣어주지? //
		sales.setSalesID(orderNo);

		sales.setChainID(chainID);
		sales.setTotSales(orderCost);
		sales.setSalesRegDate(regdate);
		insertSaleData(sales);

		System.out.println("get OrderData : " + "orderDate : " + orderDate + " orderCount : " + orderCount
				+ "orderCost : " + orderCost + " orderNo " + orderNo);

		String result = "success";

		return result;
	}

	@RequestMapping(value = "/posorderdetail.top", method = RequestMethod.POST)
	@ResponseBody
	public String orderDetailData(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject jo) {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		System.out.println("getOrderDetailData from Android. ---Start");

		System.out.println("getJsondata:" + jo);

		ArrayList<String> temp = new ArrayList<>();
		Map sjo = (Map) (jo.get("jsonData"));

		String chainID = ((String) sjo.get("chainID")).trim();
		System.out.println("orderDetailData chainID : " + chainID);
		String salesID = (salesbiz.getbychain(chainID)).getSalesID();
		System.out.println("salesID : " + salesID);

		for (int i = 1; i < sjo.size(); i++) {
			temp.add((String) sjo.get("menu" + i));

			System.out.println("menu" + i + ":" + temp.get(i - 1).trim());

			String str = temp.get(i - 1).trim();

			String targetName = "menuName";
			String targetCost = "menuCost";
			String targetCount = "menuCount";

			int targetName_num = str.indexOf(targetName);
			int targetCost_num = str.indexOf(targetCost);
			int targetCount_num = str.indexOf(targetCount);

			String[] target = new String[3];

			target[0] = str.substring(targetName_num + 10,
					(str.substring(targetName_num).indexOf(", ") + targetName_num - 1));
			System.out.println("target0 " + target[0]);
			target[1] = str.substring(targetCost_num + 9,
					(str.substring(targetCost_num).indexOf(", ") + targetCost_num));
			System.out.println("target1 " + target[1]);
			target[2] = str.substring(targetCount_num + 10,
					str.substring(targetCount_num).indexOf("}") + targetCount_num);
			System.out.println("target2 " + target[2]);

			SalesDetailVO sd = new SalesDetailVO();

			sd.setMenuName(target[0]);
			sd.setMenuPrice(target[1]);
			sd.setMenuCount(target[2]);
			sd.setSalesDetailID("SalesDetailID");
			sd.setSalesDetailRegDate(regdate);
			// id 값: ChainID 를 통해 가져옴 //
			sd.setSalesID(salesID);
			System.out.println("Insert detail data: " + sd.toString());

			insertSalesDetailData(sd);

		}

		System.out.println("sjo size: " + sjo.size());

		String result = "success";

		return result;
	}

	@RequestMapping(value = "/posgetdata.top", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray getSalesData(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println("getRequest From Android : get All Sales DATA  ---Start");

		ArrayList<SalesVO> salesList = new ArrayList<SalesVO>();

		try {
			salesList = salesbiz.get();
			for (SalesVO i : salesList) {
				System.out.println(i);
			}
			System.out.println("sales selectAll Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONArray result = new JSONArray();

		return result;
	}

	// 주문정보 넣는 함수 . 메뉴는 미포함 //
	public void insertSaleData(SalesVO sales) {

		try {
			salesbiz.register(sales);
			System.out.println("salesData Inserted");
		} catch (Exception e) {
			System.out.println("salesData Inserting Failed");
			e.printStackTrace();
		}
	}

	// 메뉴 가격, 정보 포함 상세정보 넣는 함수 //
	public void insertSalesDetailData(SalesDetailVO sd) {
		try {
			salesdetailbiz.register(sd);
			System.out.println("salesDetailData Inserted");
		} catch (Exception e) {
			System.out.println("salesDetaildata Inserting Failed");
			e.printStackTrace();
		}

	}

}