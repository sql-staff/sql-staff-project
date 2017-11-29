package com.sqlstaff.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
	
		HttpSession session = req.getSession();
		
		if(session.getAttribute("login") == null){
			logger.info("현재 유저는 로그인되어 있지 않습니다");
			res.sendRedirect("/auth/login");
			return false;
		}
		return true;
	}

}
