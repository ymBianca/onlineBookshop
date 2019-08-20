package com.newer.admin.admin.mapper;


import com.newer.admin.admin.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface AdminMapper {
    @Select("select * from admin where adminname=#{adminname}and adminpwd=#{adminpwd}")
    Admin find(@Param("adminname")String adminname ,@Param("adminpwd")String adminpwd);

}
