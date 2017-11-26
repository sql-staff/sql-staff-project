package com.sqlstaff.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sqlstaff.domain.UserVO;
import com.sqlstaff.dto.LoginDTO;
import com.sqlstaff.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}
}
