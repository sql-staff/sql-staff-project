package com.sqlstaff.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sqlstaff.domain.UserVO;
import com.sqlstaff.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.sqlstaff.mapper.UserMapper";

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return sqlSession.selectOne(namespace + ".login", dto);
	}
	
	@Override
	public void insertUser(UserVO vo) {
		sqlSession.insert(namespace+".insertUser", vo);
	}
}
