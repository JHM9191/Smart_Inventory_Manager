//package reference;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Comparator;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.rosuda.REngine.REXP;
//import org.rosuda.REngine.REXPMismatchException;
//import org.rosuda.REngine.Rserve.RConnection;
//import org.rosuda.REngine.Rserve.RserveException;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import top.frame.Biz;
//import top.vo.WarehouseVO;
//
//
//public class MainController_temp {
//
//	@Resource(name = "wbiz")
//	Biz<String, WarehouseVO> wbiz;
//
//	@RequestMapping("/main.top")
//	public ModelAndView main(ModelAndView mv, HttpServletRequest req, HttpServletResponse res) {
//
//		HttpSession session = req.getSession();
//		String u_id = (String) session.getAttribute("loginid");
//		System.out.println(u_id);
//
//		mv.addObject("uid", u_id);
//
//		
//		// uid가 null이 아닐때	
//		
//		for (WarehouseVO w : wbiz.get()) {
//			System.out.println(w);
//		}
//
//		mv.addObject("inventory_list_data", wbiz.get());
//
//		mv.addObject("inventory_realtime", "../inventory/inventory_rt");
//		mv.addObject("suggestion", null);
//		mv.addObject("analysis", null);
//		mv.setViewName("main/main");
//
//		res.setContentType("text/html; charset=UTF-8");
//
//		return mv;
//	}
//
//	@RequestMapping("/getRTInventoryData.top")
//	@ResponseBody
//	public ArrayList<RealTimeData> getRTInventoryData(ModelAndView mv) {
//		return getRealTimeInventory(wbiz.get());
//	}
//
//	/**
//	 * This method converts total inventory data list into real-time data summary
//	 * list.
//	 * 
//	 * @author johyunmin
//	 * @param warehouseData
//	 * @return JSONArray
//	 */
//	public JSONArray getRealTimeInventory(ArrayList<WarehouseVO> warehouseData) {
//		ArrayList<RealTimeData> realTimeDataList = new ArrayList<RealTimeData>();
//		int cnt_status = 0;
//		int temp = 0;
//		for (int i = 0; i < warehouseData.size(); i++) {
//			WarehouseVO w = warehouseData.get(i);
//			if (i == 0) {
//				if (warehouseData.get(i).getItem_status().equals("Inventory")) {
//					cnt_status++;
//				}
//			} else if (i > 0 && i < warehouseData.size() - 1) {
//				if (warehouseData.get(i).getItem_code().equals(warehouseData.get(i - 1).getItem_code())) {
//					if (warehouseData.get(i).getItem_status().equals("Inventory")) {
//						cnt_status++;
//					}
//				} else {
//					WarehouseVO wh = warehouseData.get(i - 1);
//					realTimeDataList.add(new RealTimeData(wh.getWarehouse_ID(), wh.getItem_code(), wh.getItem_name(),
//							cnt_status, ((double) cnt_status / ((double) i - (double) temp)) * 100));
//					temp = i;
//					cnt_status = 1;
//				}
//			} else {
//				if (warehouseData.get(i).getItem_code().equals(warehouseData.get(i - 1).getItem_code())) {
//					if (warehouseData.get(i).getItem_status().equals("Inventory")) {
//						cnt_status++;
//					}
//				}
//				WarehouseVO wh = warehouseData.get(i - 1);
//				realTimeDataList.add(new RealTimeData(wh.getWarehouse_ID(), wh.getItem_code(), wh.getItem_name(),
//						cnt_status, ((double) cnt_status / ((double) i + 1.0 - (double) temp)) * 100));
//				break;
//
//			}
//		}
//
//		// remaining ascending order sorting.
//		realTimeDataList.sort(new Comparator<RealTimeData>() {
//			@Override
//			public int compare(RealTimeData o1, RealTimeData o2) {
//				double remaining0 = o1.getRemaining();
//				double remaining1 = o2.getRemaining();
//				if (remaining0 == remaining1)
//					return 0;
//				else if (remaining0 > remaining1)
//					return 1;
//				else
//					return -1;
//			}
//		});
//		System.out.println(realTimeDataList);
//
//		return convertToJSONArray(realTimeDataList);
//	}
//
//	public JSONArray convertToJSONArray(ArrayList<RealTimeData> realTimeDataList) {
//		JSONArray ja = new JSONArray();
//		for (int i = 0; i < realTimeDataList.size(); i++) {
//			JSONObject jo = new JSONObject();
//			jo.put("wh_ID", realTimeDataList.get(i).getWh_ID());
//			jo.put("item_code", realTimeDataList.get(i).getItem_code());
//			jo.put("item_name", realTimeDataList.get(i).getItem_name());
//			jo.put("item_quantity", realTimeDataList.get(i).getItem_quantity());
//			jo.put("remaining", realTimeDataList.get(i).getRemaining());
//			ja.add(jo);
//		}
//
//		System.out.println(ja);
//		return ja;
//	}
//
//	@RequestMapping("/")
//	public ModelAndView main_simple(ModelAndView mv) {
//		mv.setViewName("main/main");
//		return mv;
//	}
//
//	// Does work yet..
//	@RequestMapping("/abc.top")
//	@ResponseBody
//	public void abc(HttpServletResponse res) throws IOException {
//		RConnection conn = null;
//		PrintWriter out = null;
//		try {
//			conn = new RConnection("192.168.64.3");
//			conn.setStringEncoding("utf8");
//			System.out.println("Connection OK");
//
//			String vector = "c(1,2,3,4)";
//			conn.eval("meanVal=mean(" + vector + ")");
//			double mean = conn.eval("meanVal").asDouble();
//			System.out.println("Mean : " + mean);
//
//			conn.eval("aa <- \"한글\"");
//			System.out.println(conn.eval("aa").asString());
//
////			conn.eval("source('~/Documents/Final_project/R_codes/top_inventory_analysis.R', encoding='UTF-8')");
////			conn.eval("setwd(\"~/Documents/Final_project/R_codes\")");
////			conn.eval("source('~/Documents/Final_project/R_codes/test.R', encoding='UTF-8')");
////			conn.eval("source('C:/R/workspace/day04/remote.R', encoding='UTF-8')");
//
//			// working sources
////			conn.eval("source('C:/R/workspace/R_script_files/test.R', encoding = 'UTF-8')");
//			conn.eval("source('C:/R/workspace/R_script_files/top_inventory_analysis.R', encoding = 'UTF-8')");
//
////			System.out.println("r3()");
////			REXP rexp = conn.eval("r3()");
////			RList rlist = rexp.asList();
////
////			String years[] = rlist.at("year").asStrings();
////			double datas[] = rlist.at("data").asDoubles();
//////
////			JSONArray ja = new JSONArray();
////			for (double d : datas) {
////				ja.add(d);
////			}
////
////			res.setContentType("text/json; charset=UTF-8");
////			out = res.getWriter();
////			out.write(ja.toJSONString());
////
////			System.out.println(ja);
//
//			REXP rexp = conn.eval("abc()");
//			double d[] = rexp.asDoubles();
//			for (double dd : d) {
//				System.out.println(dd);
//			}
//		} catch (RserveException | REXPMismatchException e) {
//			e.printStackTrace();
//		} finally {
//			conn.close();
////			out.close();
//		}
//
//	}
//
////	@RequestMapping("/login.top")
////	public ModelAndView login(ModelAndView mv, HttpServletRequest req) {
////		HttpSession session = req.getSession();
////		session.setAttribute("loginid", "ID01");
////		mv.setViewName("main");
////
////		return mv;
////	}
//
//}