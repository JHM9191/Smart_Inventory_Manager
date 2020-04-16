package top.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import top.frame.Biz;
import top.vo.ContainerVO;

@Controller
public class ContainerController {

	@Resource(name = "conbiz")
	Biz<String, ContainerVO> conbiz;

	// show container page
	@RequestMapping("/containerProgress.top")
	public ModelAndView main_simple(ModelAndView mv, HttpServletRequest req) {

		String chainID = req.getParameter("chainID");

		ArrayList<ContainerVO> conlist = new ArrayList<ContainerVO>();
		System.out.println("showContainerList");
		try {
			System.out.println("get From Container Database");
			conlist = conbiz.getForChain(chainID);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error during getting Data");
		}
		for (ContainerVO u : conlist) {
			System.out.println(u);

		}

		mv.addObject("containervo", conlist);
		mv.addObject("center", "../container/containerProgress");
		mv.setViewName("main/main");

//		res.setContentType("text/html; charset=UTF-8");

		return mv;
	}

	// Purchase IoT Container

	// Modify IoT Container

}
