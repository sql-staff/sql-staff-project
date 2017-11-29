package com.sqlstaff.persistence;

import com.sqlstaff.domain.UserVO;
import com.sqlstaff.dto.LoginDTO;

public interface UserDAO {
	
	public UserVO login(LoginDTO dto) throws Exception;
	
	public void insertUser(UserVO vo);
}
