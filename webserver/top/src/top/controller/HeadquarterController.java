package top.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
public class HeadquarterController {

	@Resource(name = "hqbiz")
	Biz<String, HeadquarterVO> hqbiz;

	@Resource(name = "userbiz")
	Biz<String, UserVO> ubiz;

	@Resource(name = "chainbiz")
	Biz<String, ChainVO> chainbiz;
	
	@Resource(name = "notibiz")
	Biz<String, NotiVO> notibiz;

	/*
	 * 1. register(signup) - completed!
	 * 2. registerimpl(signup impl) -completed!
	 * 3. signup id 중복 check - completed!
	 * 4. addAddress - completed!
	 * 5. addAddress impl -completed! (Not null일때만 성공되며, null이 존재할때는 insert가 되지 않고 redirect로
	 *                     addAddr.top 으로 해당페이지로 다시 오게된다)
	 * 6. notifications - completed!
	 * 7. mypage -update - completed!
	 */

	// 1. register
	@RequestMapping("/signup.top")
	public ModelAndView signup(ModelAndView mv) {
		System.out.println("enter into signup.top");
//		mv.addObject("center", "../user/register");
		mv.setViewName("user/register");
		return mv;
	}

	// 2. register_impl
	@RequestMapping(value = "/signupimpl.top", produces = "text/plain;charset=UTF-8")
	public String signupimpl(HeadquarterVO hq_register, HttpServletRequest request) {
		System.out.println("enter into signupimpl.top");
		try {

			// 한글 안깨지려면!
			request.setCharacterEncoding("UTF-8");

			// getparameter start
			String hq_name = request.getParameter("cname").trim();
			String hq_id = request.getParameter("hqid").trim();
			String hq_pwd = request.getParameter("hqpwd").trim();
			String hq_email = request.getParameter("hqemail").trim();
			String hq_phone = request.getParameter("hqphone").trim();
			String hq_chaincnt = request.getParameter("chaincnt").trim();
			String hq_addr = request.getParameter("caddr").trim();
			String hq_regdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

			// hq resgister set and register
			try {
				hq_register.setHqID(hq_id);
				hq_register.setHqPwd(hq_pwd);
				hq_register.setHqName(hq_name);
				hq_register.setHqEmail(hq_email);
				hq_register.setHqPhone(hq_phone);
				hq_register.setHqRegDate(hq_regdate);
				hq_register.setChainCount(hq_chaincnt);
				hq_register.setHqAddress(hq_addr);
				hqbiz.register(hq_register);

				// error 날 상황 -> utf encoding안될때, sql exception
			} catch (Exception e) {

				// null일때 error남
				System.out.println("----------SQL INSERT FAIL ----------------");
			}
		} catch (UnsupportedEncodingException e1) {
			System.out.println("----------ENCODING FAIL----------------");
			e1.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/main");
		return "redirect:main.top";
	}

	@RequestMapping("/addAddr.top")
	public ModelAndView addAddr(ModelAndView mv, HttpServletRequest request) {
		System.out.println("enter into addAddr.top");

		// addADDR과정
		HttpSession session = request.getSession();
		String hqid = (String) session.getAttribute("loginId");
		System.out.println(hqid);

		// headquarter가 담당하는 chain갯수를 jsp로 넘겨줘야 하기에 !

		HeadquarterVO hqvo = hqbiz.get(hqid);

		Integer chaincnt = Integer.parseInt(hqvo.getChainCount());
		session.setAttribute("chaincnt", chaincnt);
		// 화면으로 넘어가자!
		mv.addObject("center", "../user/AddAddr");
		mv.setViewName("main/main");
		return mv;
	}

	// sign up 할때 idcheckup

	@RequestMapping(value = "/idCheck.top", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String AjaxView(@RequestParam("hqid") String hqid, String idcheck, HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String str = "";
		try {
			System.out.println(hqid);
			idcheck = hqbiz.get(hqid).getHqID();
		} catch (Exception e) {
			System.out.println("중복이 없습니다");
		}
		System.out.println(idcheck);
		if (idcheck == null) { // 이미 존재하는 계정
			str = "YES";
		} else { // 사용 가능한 계정
			str = "NO";
		}
		return str;
	}

	// Addrimpl 과정

	@RequestMapping(value = "/addAddrimpl.top", produces = "text/plain;charset=UTF-8")
	public String addAddrimpl(HttpServletRequest request) {
		ArrayList<String> hq_addr = new ArrayList<String>();
		HttpSession session = request.getSession();
		String hqid = (String) session.getAttribute("loginid");
		String chainname = request.getParameter("chainname").trim();
		String regdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		// 주소는 여러개 이기때문에 아래와 같은 parsing과정이 필요하다

		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String name = (String) params.nextElement();
			if (name.startsWith("address")) {
				String inputaddr = request.getParameter(name);
				inputaddr = inputaddr.replace(",", " ");
				hq_addr.add(inputaddr);
				System.out.println(inputaddr + "----------- check ADDR--------------");
			}
		}
		System.out.println(hq_addr);

		// 주소를 입력하는 동시에 chain INSERT 시작된다!
		for (int i = 0; i < hq_addr.size(); i++) {
			System.out.println("check insert");
			ChainVO chain = new ChainVO();
			chain.setChainName(chainname);
			chain.setChainRegDate(regdate);
			chain.setHqID(hqid);
			chain.setChainAddress(hq_addr.get(i));

			try {
				chainbiz.register(chain);
			} catch (Exception e) {
				System.out.println("insert exception!");
				return "redirect:addAddr.top";
			}
			System.out.println("success insert chainvo :" + i + "st");
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/main");
		return "redirect:main.top";
	}
	
	
	

	@RequestMapping(value = "/read.top", method = RequestMethod.POST)
	public @ResponseBody JSONArray AjaxRead(HttpServletRequest request) {

		System.out.println("Enter into read notification read.top");

		HttpSession session = request.getSession();
		String hqid = (String) session.getAttribute("loginId");
		System.out.println(hqid);

		// step1. hq가 맡는 chainid를 모두 불러온다
		ArrayList<String> chainIdList = new ArrayList<String>();
		ArrayList<ChainVO> clist = chainbiz.getnotifi(hqid);
		for (ChainVO element : clist) {
			String chainid = element.getChainID();
			System.out.println(chainid);
			chainIdList.add(chainid);

		}
		System.out.println(chainIdList);

		// STEP2. 해당하는 CHAINID에 따른 모든 noti를 불러온다
		// 이떄의 notification은 refresh ="true"일때만 불러온다

		ArrayList<NotiVO> notiList = new ArrayList<NotiVO>();

		for (int i = 0; i < chainIdList.size(); i++) {
			NotiVO noti = notibiz.get(chainIdList.get(i));
			if (noti != null) {
				System.out.println(noti);
				notiList.add(noti);
			}
		}
		System.out.println("check notiList size : " + notiList.size());

		// step3. 이제는 자바스크립트로 보낼 애들만 !
		// and ajax로 보냇다면 -> update로 상태를 바꿔준다

		JSONArray array = new JSONArray();
		for (NotiVO element : notiList) {
			JSONObject data = new JSONObject();
			String applycnt = element.getApplyCnt();

			System.out.println("applycnt" + applycnt);
			String chainid = element.getChainID();
			System.out.println("chainid" + chainid);
			data.put("chainid", chainid);
			data.put("applycnt", applycnt);
			notibiz.refreshstate(chainid);
			array.add(data);
		}

		System.out.println(array);
		System.out.println("success ajax!");

		return array;
	}
	
	
	// 7. update page
	
	@RequestMapping("/update.top")
	public ModelAndView updatemypage(ModelAndView mv, HttpServletRequest request) {
	
		//step1. 해당 hq에 대한 정보를 가져온다!
		mv = new ModelAndView();
		HttpSession session = request.getSession();
		String hqid = (String) session.getAttribute("loginId");
		System.out.println("enter into updatepage : " + hqid);
		
		HeadquarterVO hqvo =  hqbiz.get(hqid);
		System.out.println(hqvo);
		
		ArrayList<HeadquarterVO> hqlist = new ArrayList<HeadquarterVO>();
		hqlist.add(hqvo);
		System.out.println(hqlist);
		
		mv.addObject("center", "../user/update");
		mv.addObject("hqlist", hqlist);

	
		mv.setViewName("main/main");
		return mv;
		
	}

	// 8.updateimpl

	@RequestMapping("/updateimpl.top")
	public String updateimpl(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String hqid = (String) session.getAttribute("loginId");
		System.out.println("enter into updatepage : " + hqid);
		String hqName = request.getParameter("cname").trim();
		String hqPwd = request.getParameter("hqpwd").trim();
		String hqEmail = request.getParameter("hqemail").trim();
		String hqPhone = request.getParameter("hqphone").trim();
		String chainCount = request.getParameter("chaincnt").trim();
		String hqAddress = request.getParameter("caddr").trim();

		try {
			HeadquarterVO hqupdate = new HeadquarterVO(hqName, hqPwd, hqEmail, hqPhone, hqAddress, chainCount,hqid);
			hqbiz.modify(hqupdate);
		} catch (Exception e) {
			System.out.println("sql exception!");
		}

		return "redirect:main.top";

	}
	

}
