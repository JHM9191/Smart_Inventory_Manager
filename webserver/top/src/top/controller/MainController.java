package top.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import top.model.Container;
import top.model.Item;
import top.model.Warehouse;

@Controller
public class MainController {

	@RequestMapping("/main.top")
	public ModelAndView main(ModelAndView mv, HttpServletResponse res) {
		mv.addObject("inventory", "../inventory/inventory_summary");
		mv.addObject("suggestion", null);
		mv.addObject("analysis", null);
		mv.setViewName("main/main");

		res.setContentType("text/html; charset=UTF-8");

		return mv;
	}

	@RequestMapping("/")
	public ModelAndView main_simple(ModelAndView mv) {
		mv.setViewName("main/main");
		return mv;
	}

//	@RequestMapping("/inventory_summary.top")
//	public String inventory_summary() {
//
//		return "redirect:inventory_summary.top";
//
//	}

	// Does work yet..
	@RequestMapping("/abc.top")
	@ResponseBody
	public void abc(HttpServletResponse res) {
		RConnection conn = null;
		try {
			conn = new RConnection();
			conn.setStringEncoding("utf8");
			System.out.println("Connection OK");

			String vector = "c(1,2,3,4)";
			conn.eval("meanVal=mean(" + vector + ")");
			double mean = conn.eval("meanVal").asDouble();
			System.out.println("Mean : " + mean);

			conn.eval("aa <- \"한글\"");
			System.out.println(conn.eval("aa").asString());

//			conn.eval("source('~/Documents/Final_project/R_codes/top_inventory_analysis.R', encoding='UTF-8')");
//			conn.eval("setwd(\"~/Documents/Final_project/R_codes\")");
			conn.eval("source('~/Documents/Final_project/R_codes/test.R', encoding='UTF-8')");
			System.out.println("r2()");
			REXP rexp = conn.eval("r2()");
//			REXP rexp = conn.eval("abc()");
			double d[] = rexp.asDoubles();
			for (double dd : d) {
				System.out.println(dd);
			}
		} catch (RserveException | REXPMismatchException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

	@RequestMapping("/rt_inventory")
	public void rt_inventory() {
		
		Item item01_1 = new Item("itemId01_1", "itemCode01", "itemName01", "itemCategory01", null, null);
		Item item01_2 = new Item("itemId01_2", "itemCode01", "itemName01", "itemCategory01", null, null);
		Item item01_3 = new Item("itemId01_3", "itemCode01", "itemName01", "itemCategory01", null, null);
		Item item01_4 = new Item("itemId01_4", "itemCode01", "itemName01", "itemCategory01", null, null);
		Item item01_5 = new Item("itemId01_5", "itemCode01", "itemName01", "itemCategory01", null, null);
		Item item02_1 = new Item("itemId02_1", "itemCode02", "itemName02", "itemCategory02", null, null);
		Item item02_2 = new Item("itemId02_2", "itemCode02", "itemName02", "itemCategory02", null, null);
		Item item02_3 = new Item("itemId02_3", "itemCode02", "itemName02", "itemCategory02", null, null);
		Item item02_4 = new Item("itemId02_4", "itemCode02", "itemName02", "itemCategory02", null, null);
		Item item02_5 = new Item("itemId02_5", "itemCode02", "itemName02", "itemCategory02", null, null);
		
		ArrayList<Item> itemList = new ArrayList<Item>();

		
		itemList.add(item01_1);
		itemList.add(item01_2);
		itemList.add(item01_3);
		itemList.add(item01_4);
		itemList.add(item01_5);
		itemList.add(item02_1);
		itemList.add(item02_2);
		itemList.add(item02_3);
		itemList.add(item02_4);
		itemList.add(item02_5);
		
		
		Container container01 = new Container("containerId01", "containerName01", "100", null, null, null, null);
		Container container02 = new Container("containerId02", "containerName02", "200", null, null, null, null);

		ArrayList<Container> conList = new ArrayList<Container>();
		conList.add(container01);
		conList.add(container02);
		
		
		Warehouse warehouse = new Warehouse("warehouseId01", "warehouseName01", "warehouseAddress01", conList, itemList);
	
		System.out.println(warehouse);
	}

}
