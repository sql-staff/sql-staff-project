package com.sqlstaff.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sqlstaff.domain.UserVO;
import com.sqlstaff.util.CommonUtils;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("ajaxTest")
	public String ajaxTest() {
		logger.info("ajaxTest");
		return "/test/ajaxTest";
	}
	
	@RequestMapping("uploadTestGet")
	public String uploadTestGet() {
		logger.info("uploadTest:Get");
		return "/test/uploadTest";
	}
	
	@RequestMapping("uploadTest")
	public String uploadTest(HttpServletRequest req, HttpServletResponse res) {
		logger.info("uploadTest");
		
		// 저장 위치
		String path = "/Users/lunab/Desktop/img"; 
		
		Map<String, Object> returnObject = new HashMap<String, Object>(); 
		
		try {
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req; 
			
			List<MultipartFile> mf = mhsr.getFiles("file");
			logger.info(mf.size()+"");
			
			Iterator<MultipartFile> it = mf.iterator();
			
			MultipartFile mfile = null;
			List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
			/*
			File dir = new File(path); 
			if (!dir.isDirectory()) { 
				dir.mkdirs(); 
			} 
			*/
			// 값이 나올때까지 
			while (it.hasNext()) { 
				
				// 내용을 가져와서 
				mfile = it.next();
				String origName; 
				
				//한글꺠짐 방지 
				origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8"); 
				
				// 파일명이 없다면 
				if ("".equals(origName)) { 
					System.out.println(1);
					continue; 
				} 
				
				// 파일 명 변경(uuid로 암호화) 
				String ext = origName.substring(origName.lastIndexOf('.'));
				
				if( !(ext.toLowerCase().equals(".png") || ext.toLowerCase().equals(".jpg") || ext.toLowerCase().equals(".jpeg"))) {
					continue;
				}
				
				// 확장자 
				String saveFileName = CommonUtils.getRandomString() + ext; 
				// 설정한 path에 파일저장 
				File serverFile = new File(path + File.separator + saveFileName);
				mfile.transferTo(serverFile); 
				Map<String, Object> file = new HashMap<String, Object>(); 
				file.put("origName", origName); //여기서 사용안함
				file.put("sfileName", saveFileName);
				file.put("sfile", serverFile); //여기서 사용안함
				resultList.add(file); 
			} 
			
			List<UserVO> userList = new ArrayList<UserVO>();
			
			for(Map<String, Object> m : resultList) {
				UserVO vo = new UserVO();
				vo.setUser_email("유저이메일");
				vo.setUser_pw("비번");
				vo.setUser_name("이름");
				vo.setUser_auto_login("N");
				vo.setUser_image(m.get("sfileName").toString());
				userList.add(vo);
			}
			
		} catch (UnsupportedEncodingException e) { 
			e.printStackTrace(); 
		}catch (IllegalStateException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return null;
	}
	
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
