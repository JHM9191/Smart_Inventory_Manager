package top.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import top.frame.Biz;
import top.vo.User;

@Controller
public class UserController {

	@Resource(name = "ubiz")
	Biz<String, User> ubiz;

	@RequestMapping("/login.top")
	public ModelAndView login(HttpServletRequest request) {

		System.out.println("entered login.top");
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "../user/login");
		mv.setViewName("main/main");
		return mv;
	}

	@RequestMapping("/logout.top")
	public String logout(HttpServletRequest request, ModelAndView mv) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return "redirect:main.top";
	}

	@RequestMapping("/loginimpl.top")
	public String loginimpl(HttpServletRequest request, ModelAndView mv) {

		
		String u_id = request.getParameter("ID");
		String u_pwd = request.getParameter("password");
		System.out.println(u_id + " : " + u_pwd);
		User dbuser = null;
		try {
			dbuser = ubiz.get(u_id);
			System.out.println(dbuser);
			if (dbuser.getU_id() != null) {
				if (dbuser.getU_pwd().equals(u_pwd)) {
					System.out.println("dbuser : " + dbuser.getU_id());
					HttpSession session = request.getSession();
					session.setAttribute("loginid", u_id);
					System.out.println("id 비번 일치---");
				} else {
					System.out.println("pwd 일치하지 않음");
				}
			}
		} catch (Exception e) {
			System.out.println("id값이 다를때 ");
			return "redirect:main.top";

		}

		return "redirect:main.top";
	}
}
