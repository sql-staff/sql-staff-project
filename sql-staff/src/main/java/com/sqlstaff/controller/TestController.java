package com.sqlstaff.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sqlstaff.domain.UserVO;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("doA")
	public void doA() {
		logger.info("a");
	}
	
	@RequestMapping("doB")
	public void doB() {
		logger.info("b");
	}
	
	@RequestMapping("getBean")
	public void getBean(Model model){
		logger.info("getBean 이 출력되었습니다");
		UserVO temp = new UserVO();
		temp.setUser_id(1);
		temp.setUser_email("luna");
		temp.setUser_pw("1234");
		temp.setUser_name("나영채");
		model.addAttribute("user", temp);
	}
	
	@RequestMapping("getJSON")
	public @ResponseBody UserVO getJSON(){
		UserVO temp = new UserVO();
		temp.setUser_id(1);
		temp.setUser_email("luna");
		temp.setUser_pw("1234");
		temp.setUser_name("나영채");
		
		return temp;
	}
}
