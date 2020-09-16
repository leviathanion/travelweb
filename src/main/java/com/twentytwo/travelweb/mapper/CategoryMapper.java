package com.twentytwo.travelweb.mapper;

import com.twentytwo.travelweb.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CategoryMapper {


    /*
     * 查询所有分类
     * */
    @Select("select * from category")
    List<Category> findAll();

}
