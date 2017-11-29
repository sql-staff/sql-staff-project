package com.sqlstaff.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/share")
public class ShareController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShareController.class);
	
	@RequestMapping(value="share", method=RequestMethod.GET)
	public void shareUserGET() throws Exception {
		
	}
	
	@RequestMapping(value="share", method=RequestMethod.POST)
	public void shareUserPOST() throws Exception {
		
	}
	
}
