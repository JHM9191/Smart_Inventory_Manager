package top.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/")
	public ModelAndView main_simple(ModelAndView mv) {
		mv.setViewName("main/main");
		return mv;
	}
}
