package com.newer.admin.admin.service;

import com.newer.admin.admin.domain.Admin;
import com.newer.admin.admin.mapper.AdminMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AdminService {
    private AdminMapper adminMapper;
    private SqlSession sqlSession;

    public AdminService(){
        sqlSession= SqlSessionUtil.getSqlSession();
        adminMapper=sqlSession.getMapper(AdminMapper.class);
    }
    public Admin find(String adminname,String adminpwd){
        return adminMapper.find(adminname,adminpwd);
    }


    public void close(){
        if(sqlSession!=null){
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }
}
