package com.newer.category.Mapper;


import com.newer.category.domain.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CategoryMapper {
    @Select("select * from category where cid=#{cid}")
    Category findByCid(@Param("cid") String cid);
}
