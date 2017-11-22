package com.sqlstaff.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqlstaff.service.UserService;

@Controller
@RequestMapping(value="/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String authGET() {
		logger.info("/auth");
		return "redirect:auth/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGET() {
		logger.info("/auth/login:GET");
		return "/auth/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST() {
		logger.info("/auth/login:POST");
		return null;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerGET() {
		logger.info("/auth/register:GET");
		return "/auth/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST() {
		logger.info("/auth/register:POST");
		return null;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logoutPOST() {
		logger.info("/auth/logout:POST");
		return null;
	}
}