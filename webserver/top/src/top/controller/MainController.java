package top.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import top.frame.Biz;
import top.vo.ChainVO;
import top.vo.SalesVO;

@Controller
public class MainController {

	@Resource(name = "chainbiz")
	Biz<String, ChainVO> chainbiz;

	@Resource(name = "salesbiz")
	Biz<String, SalesVO> salesbiz;

	// Show main page
	@RequestMapping("/")
	public ModelAndView main_simple(ModelAndView mv, HttpServletRequest req) {
		System.out.println("Entered main.top");
		HttpSession session = req.getSession();
		String u_id = (String) session.getAttribute("loginid");
		String who = (String) session.getAttribute("who");
		System.out.println(who);
		System.out.println(u_id);
		session.setAttribute("loginId", u_id);
		mv.addObject("center", "../main/statMain");
		mv.setViewName("main/main");
		return mv;
	}

	@RequestMapping("/mainStat.top")
	public ModelAndView mainStat(ModelAndView mv, HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Entered main.top");
		HttpSession session = req.getSession();
		String u_id = (String) session.getAttribute("loginid");
		String who = (String) session.getAttribute("who");
		System.out.println(who);
		System.out.println(u_id);
		session.setAttribute("loginId", u_id);
		mv.addObject("center", "../main/statMain");
		mv.setViewName("main/main");
		res.setContentType("text/html; charset=UTF-8");

		return mv;

	}

//	@RequestMapping("/main.top")
//	public ModelAndView main(ModelAndView mv, HttpServletRequest req, HttpServletResponse res) {
//		System.out.println("Entered main.top");
//		HttpSession session = req.getSession();
//		String u_id = (String) session.getAttribute("loginid");
//		String who = (String) session.getAttribute("who");
//		System.out.println(who);
//		System.out.println(u_id);
//		// for (ChainVO c : chainbiz.get()) {
////			System.out.println(c);
////		}
//		String year = req.getParameter("year");
//		System.out.println("year: " + year);
//		if (year == null) {
//			year = "2019";
//		}
//		ArrayList<SalesVO> salesList = salesbiz.getYear(year);
//		mv.addObject("year", year);
//		mv.addObject("salesData", salesList);
//		session.setAttribute("loginId", u_id);
//		mv.addObject("center", "../main/AllChains");
//		mv.setViewName("main/main");
//		res.setContentType("text/html; charset=UTF-8");
//
//		return mv;
//	}

	@RequestMapping(value = "/getSalesData.top", produces = "application/json; charset=utf8")
	@ResponseBody
	public void getSalesData(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Entered getSalesData.top");
		String year = req.getParameter("year");
		System.out.println("year: " + year);
		PrintWriter out = null;
		try {
			out = res.getWriter();
			ArrayList<ChainVO> chainList = chainbiz.get();
			ArrayList<SalesVO> salesList = salesbiz.getYear(year);
			System.out.println("AllChainsData Year 2019");
			System.out.println(salesList);
			JSONArray ja = new JSONArray();
			JSONArray data = new JSONArray();
			for (int i = 0; i < salesList.size(); i++) {
//				JSONArray ja_inner = new JSONArray();
//				ja_inner.add(chainList.get(i).getChainName());
//				ja_inner.add(salesList.get(i).getTotSales());
//				ja_outer.add(ja_inner);

				JSONObject jo_inin = new JSONObject();
				jo_inin.put("name", salesList.get(i).getChainName());
				jo_inin.put("y", salesList.get(i).getTotSales() / 10000);
				jo_inin.put("drilldown", salesList.get(i).getChainName());
				data.add(jo_inin);
			}
			ja.add(data);

			JSONArray ja_drilldown = new JSONArray();
			for (int j = 0; j < salesList.size(); j++) {
				System.out.println(salesList.get(j).getChainID());

				ArrayList<SalesVO> monthly = salesbiz.getMonth(year, salesList.get(j).getChainID());
				System.out.println("monthly");
				System.out.println(monthly);

				JSONObject jo = new JSONObject();
				jo.put("name", salesList.get(j).getChainName());
				jo.put("id", salesList.get(j).getChainID());
				JSONArray j_1 = new JSONArray();

				for (int k = 0; k < monthly.size(); k++) {

					JSONArray j_2 = new JSONArray();
					j_2.add(monthly.get(k).getSalesRegDate());
					j_2.add(monthly.get(k).getTotSales() / 10000);
					j_1.add(j_2);
				}
				jo.put("data", j_1);
				ja_drilldown.add(jo);
			}
			ja.add(ja_drilldown);

			System.out.println(ja.toString());
			res.setCharacterEncoding("UTF-8");
			res.setContentType("application/json; charset=UTF-8");
//			res.setCharacterEncoding("EUC-KR");
//			res.setContentType("text/json; charset=EUC-KR");
			out.write(ja.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

	// Login

	// Register

	// Show sales statistics for all chains of logged in HQ

	public ModelAndView mainStat(ModelAndView mv) {

		return mv;
	}

	// show About page
	@RequestMapping("about.top")
	public ModelAndView showAbout(ModelAndView mv) {
		mv.addObject("center", "../main/about");
		mv.setViewName("main/main");
		return mv;
	}
}
