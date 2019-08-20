package com.newer.user.mapper;


import com.newer.user.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where loginname=#{loginname} and loginpass=#{loginpass}")
    User login(@Param("loginname") String loginname,@Param("loginpass") String loginpass);
}
