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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

			String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
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

	// show inventory index
}
