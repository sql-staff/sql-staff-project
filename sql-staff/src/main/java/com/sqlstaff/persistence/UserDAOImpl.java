package com.sqlstaff.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public String getTime() {
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public void insertUser(UserVO vo) {
		sqlSession.insert(namespace+".insertUser", vo);
	}

	@Override
	public UserVO readUser(String user_email) throws Exception {
		return sqlSession.selectOne(namespace + ".selectUser", user_email);
	}

	@Override
	public UserVO readWithPw(String user_email, String user_pw) throws Exception {
		Map<String, Object> paramMap = new HashMap<String,Object>();
		
		paramMap.put("user_email", user_email);
		paramMap.put("user_pw", user_pw);
		
		return sqlSession.selectOne(namespace + ".readWithPW", paramMap);
	}

	@Override
	public List<UserVO> listAll() {
		return sqlSession.selectList(namespace + ".listAll");
	}
	
}
