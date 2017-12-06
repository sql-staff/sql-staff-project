package com.sqlstaff.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqlstaff.service.UserService;

@Controller
@RequestMapping(value="/myPage")
public class MyPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String rootGet() {
		logger.info("/myPage:GET");
		return "/user/myPage";
	}
	
	
	
}
