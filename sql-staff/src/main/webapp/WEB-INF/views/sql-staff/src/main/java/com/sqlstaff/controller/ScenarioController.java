package com.sqlstaff.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/scenario")
public class ScenarioController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String rootGET() {
		logger.info("/scenario:GET");
		return "redirect:/scenario/scenario";
	}
	
	@RequestMapping(value="/scenario", method=RequestMethod.GET)
	public String scenarioGET() {
		logger.info("/scenario/scenario:GET");
		return "/scenario/scenario";
	}
	
	@RequestMapping(value="/step", method=RequestMethod.GET)
	public String stepGET() {
		logger.info("/scenario/step:GET");
		return "/scenario/step";
	}
}
