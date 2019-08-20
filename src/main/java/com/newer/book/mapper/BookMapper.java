package com.newer.book.mapper;

import com.newer.book.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {
    @Results(value ={
            @Result(property = "bid",column = "bid",id = true),
            @Result(property = "bname",column = "bname"),
            @Result(property = "author",column = "author"),
            @Result(property = "currPrice",column = "currPrice"),
            @Result(property = "discount",column = "discount"),
            @Result(property = "press",column = "press"),
            @Result(property = "publishtime",column = "publishtime"),
            @Result(property = "edition",column = "edition"),
            @Result(property = "pageNum",column = "pageNum"),
            @Result(property = "wordNum",column = "wordNum"),
            @Result(property = "printtime",column = "printtime"),
            @Result(property = "booksize",column = "booksize"),
            @Result(property = "paper",column = "paper"),
            @Result(property = "image_w",column = "image_w"),
            @Result(property = "image_b",column = "image_b"),
            @Result(property = "category",column = "cid",
                    javaType = com.newer.category.domain.Category.class,
                    one = @One(select = "com.newer.category.Mapper.CategoryMapper.findByCid"))})
    @Select("select * from book b, category c where b.cid=c.cid and b.bid=#{bid}")
    Book findByBid(@Param("bid") String bid);


}
