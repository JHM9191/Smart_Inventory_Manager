package top.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/main.top")
	public ModelAndView main(ModelAndView mv) {
		mv.addObject("inventory", "../inventory/inventory_summary");
		mv.addObject("suggestion",null);
		mv.addObject("analysis", null);
		mv.setViewName("main/main");
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
}
