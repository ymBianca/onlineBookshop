package com.newer.user.service;



import com.newer.user.domain.User;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import com.newer.user.mapper.UserMapper;

public class UserService {
	private UserMapper userMapper;
	private SqlSession sqlSession;

	public  UserService(){
		//初始化DeptMapper
		sqlSession= SqlSessionUtil.getSqlSession();
		userMapper=sqlSession.getMapper(UserMapper.class);
	}

	public User login(String loginname, String loginpass){
		return userMapper.login(loginname,loginpass);
//		return user;
	}

	public void close(){
		if(sqlSession!=null){
			SqlSessionUtil.closeSqlSession(sqlSession);
		}
	}


}
