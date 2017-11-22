package com.sqlstaff.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sqlstaff.domain.UserVO;
import com.sqlstaff.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;
	
	@Override
	public String getTime() {
		return dao.getTime();
	}

	@Override
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}

	@Override
	public UserVO readUser(String user_email) throws Exception {
		return dao.readUser(user_email);
	}

	@Override
	public UserVO readWithPw(String user_email, String user_pw) throws Exception {
		return dao.readWithPw(user_email, user_pw);
	}

	@Override
	public List<UserVO> listAll() {
		return dao.listAll();
	}

}
