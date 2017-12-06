package com.sqlstaff.service;

import com.sqlstaff.domain.UserVO;
import com.sqlstaff.dto.LoginDTO;
import com.sqlstaff.dto.RegisterDuplicatedDTO;

public interface UserService {
	
	public UserVO login(LoginDTO dto) throws Exception;
	
	public void insertUser(UserVO vo);
	
	public boolean registerDuplicate(RegisterDuplicatedDTO dto);
}
