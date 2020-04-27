package top.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import top.frame.Biz;
import top.vo.ChainVO;
import top.vo.HeadquarterVO;
import top.vo.NotiVO;
import top.vo.UserVO;

@Controller
public class UserController {

	@Resource(name = "userbiz")
	Biz<String, UserVO> userbiz;

	@Resource(name = "hqbiz")
	Biz<String, HeadquarterVO> hqbiz;

	@Resource(name = "chainbiz")
	Biz<String, ChainVO> chainbiz;

	@Resource(name = "notibiz")
	Biz<String, NotiVO> notibiz;

	/*
	 * 1.login (completed!) 2.logout(completed!) 3.logincheck up(completed!)
	 * 4.loginimpl(completed!) 5.apply.top (completed!) 6.applyimpl.top (completed!)
	 */

	// 1.login
	@RequestMapping("/login.top")
	public ModelAndView login(HttpServletRequest request) {

		System.out.println("entered login.top");
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "../user/login");
		mv.setViewName("main/main");
		return mv;
	}

	// 2.logout
	@RequestMapping("/logout.top")
	public String logout(HttpServletRequest request, ModelAndView mv) {
		System.out.println("entered into logout.top");
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return "redirect:main.top";
	}

	// 3. login ID && PWD CHECK UP!

	// 변수에 대한 설명!
	// id: 사용자가 웹 안에서 입력한 id
	// pwd: 사용자가 웹 안에서 입력한 pwd
	// radio : 사용자가 선택한 radiobutton(user vs headquarter)
	@ResponseBody
	@RequestMapping(value = "/logincheckup.top", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String AjaxView(@RequestParam("ID") String id, @RequestParam("password") String pwd,
			@RequestParam("radio") String radio, String str, HttpServletRequest request)
			throws UnsupportedEncodingException {
		System.out.println("enter into login check!");
		request.setCharacterEncoding("UTF-8");

		try {

			switch (radio) {
			case "hq":
				HeadquarterVO hq = hqbiz.get(id.trim());
				System.out.println("hq check : " + hq);
				if (hq.getHqPwd().equals(pwd.trim())) {
					str = "Yes";
				} else {
					str = "NO";
				}
				break;
			case "user":
				UserVO user = userbiz.get(id.trim());
				System.out.println("user check : " + user);
				if (user.getUserPwd().equals(pwd.trim())) {
					str = "Yes";
				} else {
					str = "NO";
				}
				break;
			default:
				str = "NO";
				break;
			}
		} catch (Exception e) {
			str = "NO";
		}
		System.out.println(str);
		return str;
	}

	// 4. LoginImpl - onemoretime 확인해준다
	@RequestMapping("/loginimpl.top")
	public String loginimpl(HttpServletRequest request, ModelAndView mv) {

		System.out.println("enter into loginimpl!");
		String id = request.getParameter("ID").trim();
		String pwd = request.getParameter("password");
		String radio = request.getParameter("radio");

		HttpSession session = request.getSession();
		session.setAttribute("loginId", id);
		session.setAttribute("who", radio);

		if (radio.equals("hq")) {
			HeadquarterVO dbhquser = new HeadquarterVO();
			dbhquser = hqbiz.get(id);
			try {
				if (dbhquser.getHqID() != null) {
					if (dbhquser.getHqPwd().equals(pwd)) {
						session.setAttribute("loginid", id);
						session.setAttribute("chaincnt", dbhquser.getChainCount());
						System.out.println("----------- hqid 비번 일치--------------");
					} else {
						System.out.println("---------- hq pwd 일치하지 않음-------------");
					}
				}
			} catch (Exception e) {
				System.out.println("sqlexcetion");
				e.printStackTrace();

			}

		} else {
			UserVO dbuser = null;
			dbuser = userbiz.get(id);
			try {
				if (dbuser.getUserID() != null) {
					if (dbuser.getUserPwd().equals(pwd)) {
						System.out.println("dbuser : " + dbuser.getUserID());
						session.setAttribute("loginid", id);

						System.out.println("----------- user id 비번 일치--------------");

					} else {
						System.out.println("---------- user pwd 일치하지 않음-------------");
					}
				}
			} catch (Exception e) {
				System.out.println("sqlexcetion ");
				return "redirect:main.top";
			}
		}
		return "redirect:main.top";
	}

	// 5. user count 신청자 page
	@RequestMapping("/apply.top")
	public ModelAndView apply(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String usrid = (String) session.getAttribute("loginId");
		System.out.println(usrid + "  : entered into apply.top");

		/*
		 * user cnt apply jsp 안에 select로 chainname 을 선택하는 구간이 있음 그렇기 때문에 해당 유저의
		 * chainname을 불러오기 위해 getname(chainId)가 필요함
		 */

		String chainId = userbiz.get(usrid).getChainID();
		String cname = chainbiz.getchainname(chainId).getChainName();

		mv.addObject("center", "../user/apply");
		mv.addObject("cname", cname);
		mv.setViewName("main/main");
		return mv;
	}

	// 6. applyimpl.top(user가 신청하자 마자 -> headquarter에게 notification)

	@RequestMapping("/applyimpl.top")
	public ModelAndView applyimpl(HttpServletRequest request) {
		System.out.println("entered applyimpl.top");
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();

		// step1. notivo에 필요한 var생성
		NotiVO notivo = new NotiVO();
		String usrid = (String) session.getAttribute("loginId");
		String chainId = userbiz.get(usrid).getChainID();
		String regdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		String ucnt = request.getParameter("ucnt");
		System.out.println("ucnt : " + ucnt);

		// step2. notivo에 해당 변수 저장
		notivo.setChainID(chainId);
		notivo.setUserID(usrid);
		notivo.setApplyCnt(ucnt);
		notivo.setRegDate(regdate);
		notivo.setRefresh("true".trim());
		try {
			notibiz.register(notivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("success!");
		mv.addObject("center", "../user/apply");
		mv.setViewName("main/main");
		return mv;
	}

	// Tablet user login confirmation
	@RequestMapping("/loginChainTablet.top")
	@ResponseBody
	public String loginChainTablet(HttpServletRequest req, HttpServletResponse res) {

		String userID = req.getParameter("id");
		String userPwd = req.getParameter("pwd");

		System.out.println(userID + " " + userPwd);

		UserVO user = userbiz.get(userID);

		if (userPwd.equals(user.getUserPwd())) {
			System.out.println("password matching");
			return "1";
		} else {
			System.out.println("password mismatch!");
			return "0";
		}

	}

}
