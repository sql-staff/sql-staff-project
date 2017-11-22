package com.sqlstaff.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object Handler) throws Exception {
		HttpSession session = req.getSession();
		
		// 이미 로그인 되어있을때 로그인 정보 삭제
		if(session.getAttribute(LOGIN) != null){
			logger.info("이전 로그인 정보를 삭제합니다");
			session.removeAttribute(LOGIN);
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object Handler, ModelAndView modelAndView) throws Exception {
		HttpSession session = req.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		
		//ModelMap에 UserVO가 있을경우 로그인 성공
		Object userVO = modelMap.get("UserVO");
		if(userVO != null){
			logger.info("로그인 성공");
			session.setAttribute(LOGIN, userVO); //세션에 로그인 유저 등록
			res.sendRedirect("/"); //리다이렉트
		}else {
			//처리하지않을시 기존 페이지로 리다이렉트
			logger.info("로그인 실패");
			modelMap.addAttribute("msg", "아이디나 비밀번호가 올바르지 않습니다");
		}
	}
}
