package top.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	// Show main page
	@RequestMapping("/")
	public ModelAndView main_simple(ModelAndView mv) {
		mv.setViewName("main/main");
		return mv;
	}

	@RequestMapping("/main.top")
	public ModelAndView main(ModelAndView mv, HttpServletRequest req, HttpServletResponse res) {

//		HttpSession session = req.getSession();
//		String u_id = (String) session.getAttribute("loginid");
//		System.out.println(u_id);

		String u_id = "test01";
		mv.addObject("loginId", u_id);

		mv.addObject("AllChainsVisualAnalysis", "../main/AllChains");
		mv.setViewName("main/main");

		res.setContentType("text/html; charset=UTF-8");

		return mv;
	}

	// Login

	// Register

	// Show sales statistics for all chains of logged in HQ

	public ModelAndView mainStat(ModelAndView mv) {

		return mv;
	}

}
