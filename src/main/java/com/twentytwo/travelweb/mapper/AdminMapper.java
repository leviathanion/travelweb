package com.twentytwo.travelweb.mapper;

import com.twentytwo.travelweb.entity.Admin;
import com.twentytwo.travelweb.entity.Company;
import com.twentytwo.travelweb.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select * from admin_info where admin_id=#{admin_id}")
    Admin getAdminById(String admin_id);


}
