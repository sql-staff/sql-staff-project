package com.sqlstaff.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqlstaff.domain.UserVO;
import com.sqlstaff.dto.LoginDTO;
import com.sqlstaff.service.UserService;

@Controller
@RequestMapping(value="/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String authGET() {
		logger.info("/auth:GET");
		return "redirect:auth/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGET() {
		logger.info("/auth/login:GET");
		return "/auth/login";
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		logger.info("/auth/loginProcess:POST");
		UserVO vo = userService.login(dto);
		if(vo == null) {
			return; // login fail
		}
		model.addAttribute("UserVO", vo);
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerGET() {
		logger.info("/auth/register:GET");
		return "/auth/register";
	}
	
	@RequestMapping(value="/registerProcess", method=RequestMethod.POST)
	public void registerPOST() {
		logger.info("/auth/registerProcess:POST");
		return null;
	}
	
	@RequestMapping(value="/logoutProcess", method=RequestMethod.POST)
	public String logoutPOST() {
		logger.info("/auth/logoutProcess:POST");
		return null;
	}
}