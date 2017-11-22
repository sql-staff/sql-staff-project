package com.sqlstaff.service;

import java.util.List;

import com.sqlstaff.domain.UserVO;

public interface UserService {
	
	public String getTime();
	
	public void insertUser(UserVO vo);
	
	public UserVO readUser(String user_email) throws Exception;
	
	public UserVO readWithPw(String user_email, String user_pw) throws Exception;
	
	public List<UserVO> listAll();
}
