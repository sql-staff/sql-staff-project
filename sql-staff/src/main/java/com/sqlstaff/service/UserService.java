package com.sqlstaff.service;

import java.util.List;

import com.sqlstaff.domain.UserVO;
import com.sqlstaff.dto.LoginDTO;

public interface UserService {
	
	public UserVO login(LoginDTO dto) throws Exception;
	
	public void insertUser(UserVO vo);
}
