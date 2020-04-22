package top.controller;

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

		ArrayList<ChainVO> chainList = chainbiz.getChain("cafe_TOP_hq");

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
	public void regiContainer(@RequestBody ArrayList<ConRegiVO> array) {

		System.out.println("entered regiContainer method");
		System.out.println(array);
		ConRegiVO object = array.get(0);
		System.out.println(object.toString());

		for (ConRegiVO c : array) {
			IngredientVO ing = ingbiz.get(c.getIngID());
			System.out.println(ing);

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
			double conWarninWeight = (conWarningQuantity * conUnitWeight);

			String chainID = c.getChainID();
			if (chainID.equals("same")) {
				ArrayList<ChainVO> chainList = chainbiz.getChain("cafe_TOP_hq");
				for (ChainVO ch : chainList) {
					String chainID_db = ch.getChainID();
					System.out.println(chainID_db);
					ContainerVO con = new ContainerVO(null, conSize, conMaxWeight, conFullWeight, conFullQuantity,
							conWarninWeight, conWarningQuantity, 0, 0, conUnitWeight, ing.getIngID(), chainID_db);
					try {
						conbiz.register(con);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				System.out.println(chainID);
				ContainerVO con = new ContainerVO(null, conSize, conMaxWeight, conFullWeight, conFullQuantity,
						conWarninWeight, conWarningQuantity, 0, 0, conUnitWeight, ing.getIngID(), chainID);
				try {
					conbiz.register(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Finish registering container");
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
