package top.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import top.frame.Biz;
import top.vo.ChainVO;
import top.vo.ConRegiVO;
import top.vo.ContainerVO;
import top.vo.IngredientVO;
import top.vo.OrderDetailVO;

@Controller
public class ContainerController {

	@Resource(name = "conbiz")
	Biz<String, ContainerVO> conbiz;
	@Resource(name = "ingbiz")
	Biz<String, IngredientVO> ingbiz;
	@Resource(name = "orderdetailbiz")
	Biz<String, OrderDetailVO> odbiz;
	@Resource(name = "chainbiz")
	Biz<String, ChainVO> chainbiz;

	// show container page
	@RequestMapping("/containerProgress.top")
	public ModelAndView redirectToRealTimeContainerPage(ModelAndView mv, HttpServletRequest req) {
		String chainID = req.getParameter("chainID");

		mv.addObject("totSale", "2,490");
		mv.addObject("chainID", chainID);
		mv.addObject("center", "../container/containerProgress");
		mv.setViewName("main/main");
		return mv;
	}

//	// show container register page
//	@RequestMapping("/containerRegister.top")
//	public ModelAndView registerContainer(ModelAndView mv, HttpServletRequest req) {
////		mv.addObject("chainID", chainID);
//		mv.addObject("center", "../container/containerRegister");
//		mv.setViewName("main/main");
//		return mv;
//	}

	// show container register wizard page
	@RequestMapping("/containerRegisterWizard.top")
	public ModelAndView registerWizardContainer(ModelAndView mv, HttpServletRequest req) {
//		mv.addObject("chainID", chainID);
		HttpSession session = req.getSession();
		String hqID = (String) session.getAttribute("hqID");
		System.out.println("hqID : " + hqID);
		ArrayList<IngredientVO> ingList = ingbiz.get();
		for (IngredientVO ing : ingList) {
			System.out.println(ing);
		}

		ArrayList<ChainVO> chainList = chainbiz.getbyhq("cafe_TOP_hq");

		for (ChainVO c : chainList) {
			System.out.println(c);
		}

		mv.addObject("center", "../container/containerRegisterWizard");
		mv.addObject("ingList", ingList);
		mv.addObject("chainList", chainList);
		mv.setViewName("main/main");
		return mv;
	}

	// add container
	@RequestMapping("/insertContainer.top")
	@ResponseBody
	public ArrayList<Object> insertContainer(HttpServletRequest req, HttpServletResponse res) {
		String size = req.getParameter("size");
		String ing = req.getParameter("ing");
		String cnt = req.getParameter("cnt");

		for (OrderDetailVO od : odbiz.get()) {
			System.out.println(od);
		}

//		mv.addObject("containerList", odbiz.get());

		return null;
	}

	@RequestMapping(value = "/regiContainer.top", method = RequestMethod.POST)
	@ResponseBody
//	public HashMap<String, ArrayList<ContainerVO>> regiContainer(@RequestBody ArrayList<ConRegiVO> array) {
	public ArrayList<ContainerVO> regiContainer(@RequestBody ArrayList<ConRegiVO> array, HttpServletRequest req) {
		HttpSession session = req.getSession();
//		String hqID = (String) session.getAttribute("hqID");
//		String hqName = (String) session.getAttribute("hqName");

		String hqID = "cafe_TOP_hq";
		String hqName = "카페TOP본사";

		System.out.println("entered regiContainer method");
		System.out.println(array);
		ConRegiVO object = array.get(0);
		System.out.println(object.toString());

		String regDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		System.out.println("regDate : " + regDate);

		for (ConRegiVO c : array) {
			IngredientVO ing = ingbiz.get(c.getIngID());
			System.out.println(ing);
			String ingID = ing.getIngID();
			String ingName = ing.getIngName();
			double ingWeight = ing.getIngWeight();

			String conSize = c.getSize();

			Double conMaxWeight = 0.0;
			if (conSize.equals("small")) {
				conMaxWeight = 20.0;
			} else if (conSize.equals("medium")) {
				conMaxWeight = 100.0;
			} else if (conSize.equals("large")) {
				conMaxWeight = 500.0;
			}

			double conUnitWeight = ing.getIngWeight();

			int conFullQuantity = c.getQuantity();
			double conFullWeight = (conFullQuantity * conUnitWeight);

			int conWarningQuantity = c.getWarning();
			double conWarningWeight = (conWarningQuantity * conUnitWeight);

			String chainID_selected = c.getChainID();
			String chainName_selected = c.getChainName();
			if (chainID_selected.equals("same")) {
				ArrayList<ChainVO> chainList = chainbiz.getbyhq(hqID);
				for (ChainVO ch : chainList) {
					String chainID = ch.getChainID();
					String chainName = ch.getChainName();
					System.out.println(chainID);

					/**
					 * 
					 * String conID; String conSize; double conMaxWeight; String regDate; String
					 * updateDate; double conFullWeight; int conFullQuantity; double
					 * conWarningWeight; int conWarningQuantity; double conCurrWeight; int
					 * conCurrQuantity; double conUnitWeight; String ingID; String ingName; String
					 * chainID; String chainName; String hqID; String hqName;
					 * 
					 * 
					 * 
					 */

					ContainerVO con = new ContainerVO(null, conSize, conMaxWeight, regDate, "", conFullWeight,
							conFullQuantity, conWarningWeight, conWarningQuantity, 0, 0, conUnitWeight, ingID, ingName,
							ingWeight, chainID, chainName, hqID, hqName);
					try {
						conbiz.register(con);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				System.out.println(chainID_selected);
				System.out.println(chainName_selected);
				ContainerVO con = new ContainerVO(null, conSize, conMaxWeight, regDate, "", conFullWeight,
						conFullQuantity, conWarningWeight, conWarningQuantity, 0, 0, conUnitWeight, ingID, ingName,
						ingWeight, chainID_selected, chainName_selected, hqID, hqName);
				try {
					conbiz.register(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Finish registering container");
		return conbiz.getbyhq("cafe_TOP_hq");

		/**
		 * 
		 * 
		 * Container Table 에 추가되어야할 컬럼들: 1. hqID 2. ingName 3. ingUnit
		 * 
		 *
		 * 
		 * 
		 */
		// return (JSONArray) array;
//		return (JSONArray) conbiz.getChain("cafe_TOP_hq");
//		ArrayList<ChainVO> chainList = chainbiz.getChain("cafe_TOP_hq");

//		HashMap<String, ArrayList<ContainerVO>> map = new HashMap<String, ArrayList<ContainerVO>>();
//		for (ChainVO ch : chainList) {
//			map.put(ch.getChainName(), conbiz.getForChain(ch.getChainID()));
//		}

//		map.put("map", conbiz.getChain("cafe_TOP_hq"));
//		System.out.println(map);
//		return map;

	}

	// show container register wizard page
	@RequestMapping("/showContainerUpdateList.top")
	public ModelAndView showContainerUpdateList(ModelAndView mv, HttpServletRequest req) {
//			mv.addObject("chainID", chainID);
		HttpSession session = req.getSession();
		String hqID = (String) session.getAttribute("hqID");
		System.out.println("hqID : " + hqID);

		ArrayList<ContainerVO> conList = conbiz.getbyhq("cafe_TOP_hq");

		for (ContainerVO c : conList) {
			System.out.println(c);
		}

		mv.addObject("center", "../container/showContainerUpdateList");
		mv.addObject("conList", conList);
		mv.addObject("ingList", ingbiz.get());
		mv.setViewName("main/main");
		return mv;
	}

	@RequestMapping(value = "/containerUpdateImpl.top", method = RequestMethod.POST)
	@ResponseBody
//	public HashMap<String, ArrayList<ContainerVO>> regiContainer(@RequestBody ArrayList<ConRegiVO> array) {
	public ContainerVO containerUpdateImpl(@RequestBody ContainerVO c, HttpServletRequest req) {
		System.out.println("entered containerUpdateImpl method");
		System.out.println(c.toString());

		String conUpdateDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		System.out.println("conUpdateDate : " + conUpdateDate);

		String conID = c.getConID();
		String ingID = c.getIngID();
		System.out.println("ingID : " + ingID);
		IngredientVO ing_db = ingbiz.get(ingID);
		String ingName = ing_db.getIngName();
		double ingWeight = ing_db.getIngWeight();

		double conUnitWeight = ingWeight;
		int conFullQuantity = c.getConFullQuantity();
		double conFullWeight = (conFullQuantity * conUnitWeight);
		int conWarningQuantity = c.getConWarningQuantity();
		double conWarningWeight = (conWarningQuantity * conUnitWeight);

		ContainerVO container_db = conbiz.get(conID);
		container_db.setConUpdateDate(conUpdateDate);
		container_db.setConFullWeight(conFullWeight);
		container_db.setConFullQuantity(conFullQuantity);
		container_db.setConWarningWeight(conWarningWeight);
		container_db.setConWarningQuantity(conWarningQuantity);
		container_db.setIngID(ingID);
		container_db.setIngName(ingName);
		container_db.setIngWeight(conWarningWeight);

		try {
			conbiz.modify(container_db);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ContainerVO container_modified = conbiz.get(conID);
		System.out.println(container_modified);
		return container_modified;
	}

	@RequestMapping("/containerRemoveImpl.top")
	@ResponseBody
	public void containerRemoveImpl(HttpServletRequest req) {
		System.out.println("entered containerRemoveImpl");
		String conID = req.getParameter("conID");
		try {
			conbiz.remove(conID);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// show container page
//	@RequestMapping("/containerProgress.top")
//	public ModelAndView main_simple(ModelAndView mv, HttpServletRequest req) {
//
//		String chainID = req.getParameter("chainID");
//
//		ArrayList<ContainerVO> conlist = new ArrayList<ContainerVO>();
//		System.out.println("showContainerList");
//		try {
//			System.out.println("get From Container Database");
//			conlist = conbiz.getForChain(chainID);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Error during getting Data");
//		}
//		for (ContainerVO u : conlist) {
//			System.out.println(u);
//
//		}
//
//		mv.addObject("containervo", conlist);
//		mv.addObject("center", "../container/containerProgress");
//		mv.setViewName("main/main");
//
////		res.setContentType("text/html; charset=UTF-8");
//
//		return mv;
//	}

	// Purchase IoT Container

	// Modify IoT Container

}
