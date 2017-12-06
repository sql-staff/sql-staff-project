package com.sqlstaff.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sqlstaff.domain.UserVO;
import com.sqlstaff.dto.LoginDTO;
import com.sqlstaff.dto.RegisterDuplicatedDTO;
import com.sqlstaff.service.UserService;

@Controller
@RequestMapping(value="/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String rootGET() {
		logger.info("/auth:GET");
		return "redirect:/auth/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGET(@ModelAttribute("dto") LoginDTO dto) {
		logger.info("/auth/login:GET");
		return "/auth/login";
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		logger.info("/auth/loginProcess:POST");
		
		UserVO vo = userService.login(dto);
		if(vo == null) {
			logger.info("login fail");
			return; // login fail
		}
		model.addAttribute("UserVO", vo);
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerGET() {
		logger.info("/auth/register:GET");
		return "/auth/register";
	}
	
	@RequestMapping(value="/registerDuplicate", method=RequestMethod.POST, produces="application/json; charset=UTF-8", consumes="application/json; charset=UTF-8")
	@ResponseBody
	public String registerDuplicateIdPOST(@RequestBody Map<String, String> reqMap, HttpServletResponse response){
		logger.info("/auth/registerDuplicate:POST");
		logger.info(reqMap.toString());
		System.out.println(reqMap.get("userEmail"));
		
		RegisterDuplicatedDTO dto = new RegisterDuplicatedDTO();
		dto.setUser_email(reqMap.get("userEmail"));
		
		boolean isDuplicate = userService.registerDuplicate(dto);
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put("isDuplicated", isDuplicate);
		
		List<Object> dataList = new ArrayList<Object>();
		dataList.add(dataMap);
		
		resMap.put("data", dataList);
		resMap.put("succeed", true);
		
		JSONObject json = new JSONObject(resMap);
        
		return json.toJSONString();
	}
	
	@RequestMapping(value="/registerProcess", method=RequestMethod.POST)
	public void registerPOST() {
		logger.info("/auth/registerProcess:POST");
	}
	
	@RequestMapping(value="/logoutProcess", method=RequestMethod.POST)
	public String logoutPOST(HttpSession session, RedirectAttributes rttr) {
		logger.info("/auth/logoutProcess:POST");
		session.invalidate(); //세션 파괴
		rttr.addFlashAttribute("msg", "로그아웃되었습니다.");
		return "redirect:/";
	}
}