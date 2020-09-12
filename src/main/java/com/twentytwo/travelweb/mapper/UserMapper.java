package com.twentytwo.travelweb.mapper;

import com.twentytwo.travelweb.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user_info")
    List<User> getAllUsers();

    @Insert("insert into user_info(user_id,user_name,user_pwd,user_sex,user_age,user_address,user_email,user_job,user_remark,user_create_date,user_img_url) values (#{user_id},#{user_name},#{user_pwd},#{user_sex},#{user_age},#{user_address},#{user_email},#{user_job},#{user_remark},sysdate(),#{user_img_url})")
    Integer addUser(User user);

    @Delete("delete from user_info where user_id = ${user_id}")
    Integer deleteUser(String user_id);

    @Select("select * from user_info where user_id=#{user_id}")
    User getUserById(String user_id);

    @Update("update user_info set user_name=#{user_name},user_pwd=#{user_pwd},user_sex=#{user_sex},user_age=#{user_age},user_address=#{user_address},user_email=#{user_email},user_job=#{user_job},user_remark=#{user_remark},user_img_url=#{user_img_url} where user_id=#{user_id}")
    Integer updateUserById(User user);

    @Update("update user_info set user_privilege=#{user_privilege} where user_id=#{user_id}")
    Integer updateUserPrivilege(String user_id,Integer user_privilege);

}
