package top.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import top.frame.Biz;
import top.vo.SalesVO;

@Controller
public class StatisticController {

	@Resource(name = "salesbiz")
	Biz<String, SalesVO> salesbiz;

	// Inventory Analysis
	@RequestMapping("/showDailySalesChart.top")
	@ResponseBody
	public void showDailySalesChart(ModelAndView mv, HttpServletResponse res) {

		String regDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		String regData_temp = "20170101";
		ArrayList<SalesVO> dailySalesList = salesbiz.getDailyAllChain(regData_temp);

		System.out.println("dailySalesList : " + dailySalesList);

		JSONArray ja = new JSONArray();
		for (int i = 0; i < dailySalesList.size(); i++) {
			JSONObject jo = new JSONObject();
			jo.put("name", dailySalesList.get(i).getChainName());
			JSONArray data_ = new JSONArray();

			String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			data_.add(now);
			data_.add(dailySalesList.get(i).getTotSales());
			jo.put("data", data_);
			ja.add(jo);
		}

		System.out.println("ja : " + ja);
		PrintWriter out = null;
		try {
			out = res.getWriter();
			res.setCharacterEncoding("UTF-8");
			res.setContentType("application/json; charset=UTF-8");
			out.write(ja.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

	// Get analysis result from R

	// show ABC analysis results

	// show EOQ model analysis
	@RequestMapping(value = "/EOQparameter.top", method = RequestMethod.POST)
	@ResponseBody
	public String EOQparameter(@RequestBody JSONObject jo) {
		System.out.println(jo);

//		if (((String) jo.get("order_cost")).equals("")) {
//			return "";
//		}

		return calculateEOQ(jo).toString();
	}

	public JSONArray calculateEOQ(JSONObject jo) {
		System.out.println("entered calculateEOQ()");
		int demand_quantity = Integer.parseInt((String) jo.get("demand"));
		double order_cost = Double.parseDouble((String) jo.get("order_cost"));
		int order_quantity = Integer.parseInt((String) jo.get("order_quantity"));
		double holding_cost = Double.parseDouble((String) jo.get("holding_cost"));
		String ingredient = (String) jo.get("ingredient");
		double ingPrice = Double.parseDouble((String) jo.get("ingPrice"));
//		ArrayList<String> ingList = (ArrayList<String>) jo.get("ingList");

		System.out.println(order_cost);
		System.out.println(order_quantity);
		System.out.println(holding_cost);
		System.out.println(ingredient);
		System.out.println(ingPrice);
//		System.out.println(ingList);
//		System.out.println(ingList.get(0));

		double D = demand_quantity;

		double S = ((double) (order_quantity * ingPrice)) + ((double) (demand_quantity / order_quantity) * order_cost);

		double H = ((double) (order_quantity / 2)) * (holding_cost / D);

		System.out.println("D : " + D);
		System.out.println("S : " + S);
		System.out.println("H : " + H);
		RConnection conn = null;
		PrintWriter out = null;

		JSONArray send = new JSONArray();

		try {
			conn = new RConnection();
//			conn = new RConnection("15.165.163.102", 6311);

			conn.setStringEncoding("utf8");
			System.out.println("Connection OK");

			String vector = "c(1,2,3,4)";
			conn.eval("meanVal=mean(" + vector + ")");
			double mean = conn.eval("meanVal").asDouble();
			System.out.println("Mean : " + mean);

			conn.eval("aa <- \"한글\"");
			System.out.println(conn.eval("aa").asString());

//			conn.eval("source('C:/R/workspace/TOP/top_inventory_analysis.R',encoding = 'UTF-8')");
//			conn.eval("source('~/Documents/Final_project/R_codes/top_inventory_analysis.R',encoding = 'UTF-8')");
			conn.eval("source('~/R_workspace/top_inventory_analysis.R',encoding = 'UTF-8')");

//			REXP rexp = conn.eval("test2(9)");
//			String result = rexp.asString();
//			System.out.println(result);

			REXP rexp = conn.eval("top_EOQ(" + D + "," + S + "," + H + ", 0, 100)");
			RList rlist = rexp.asList();
			double periods[] = rlist.at("period").asDoubles();
			double inventories[] = rlist.at("inventory").asDoubles();

			int cycle = 0;

			System.out.println("data size : " + periods.length);
			JSONObject input = new JSONObject();
			JSONArray label = new JSONArray();

			JSONArray data = new JSONArray();

			String year = "2020-";

			for (int i = 0; i < periods.length; i++) {
				JSONObject data_obj = new JSONObject();
				double p = periods[i];
				System.out.println(p);
				String month = "";
				double m_double = (double) (((p * (365.0 / 12.0))) / ((365.0 / 12.0)) + 1.0);
				System.out.println("m_double : " + m_double);
				int m = (int) m_double;
				System.out.println("m : " + m);

				month = convertMonth(m);
				if (m == 13) {
					year = "2021-";
				}

				int d = (int) ((m_double - ((double) m)) * (365.0 / 12.0)) + 1;

				if (i == 1) {
					cycle = d;
				}

				System.out.println("d : " + d);
				String day = "";
				if (d == 1) {
					day = "01";
				} else if (d == 2) {
					day = "02";
				} else if (d == 3) {
					day = "03";
				} else if (d == 4) {
					day = "04";
				} else if (d == 5) {
					day = "05";
				} else if (d == 6) {
					day = "06";
				} else if (d == 7) {
					day = "07";
				} else if (d == 8) {
					day = "08";
				} else if (d == 9) {
					day = "09";
				} else if (d == 30 && m == 2) {
					day = "01";
					month = changeMonthOverflow(m);
				} else if (d == 31 && (m == 2 || m == 4 || m == 6 || m == 9 || m == 11)) {
					day = "01";
					month = changeMonthOverflow(m);
				} else if (d == 32) {
					month = changeMonthOverflow(m);
					day = "01";
				} else {
					day = d + "";
				}

				System.out.println(year + month + "-" + day + "T13:00:00Z");
				data_obj.put("t", year + month + "-" + day + "T13:00:00Z");
				label.add(year + month + "-" + day + "T13:00:00Z");

				data_obj.put("y", (int) inventories[i]);
				data.add(data_obj);
			}

			input.put("label", label);
			input.put("data", data);
			input.put("cycle", cycle);
			input.put("order", periods.length / 2);
			input.put("quantity", (int) inventories[0]);

			send.add(input);

		} catch (RserveException | REXPMismatchException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return send;
	}

	public String convertMonth(int m) {

		String month = "";
		if (m == 1) {
			month = "01";
		} else if (m == 2) {
			month = "02";

		} else if (m == 3) {
			month = "03";

		} else if (m == 4) {
			month = "04";

		} else if (m == 5) {
			month = "05";

		} else if (m == 6) {
			month = "06";

		} else if (m == 7) {
			month = "07";

		} else if (m == 8) {
			month = "08";

		} else if (m == 9) {
			month = "09";

		} else if (m == 13) {
			month = "01";
		} else {
			month = m + "";
		}

		return month;

	}

	public String changeMonthOverflow(int m) {
		String month = convertMonth(m + 1);
		return month;

	}

}
