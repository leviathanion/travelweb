package com.twentytwo.travelweb.mapper;

import com.twentytwo.travelweb.entity.Company;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface CompanyMapper {

    @Select("select * from com_info")
    List<Company> getAllCompanies();

    @Insert("insert into com_info (com_id,com_pwd,com_email,com_name,com_address,com_identify,com_create_date) values (#{com_id},#{com_pwd},#{com_email},#{com_name},#{com_address},#{com_identify},sysdate())")
    Integer addCompany(Company company);

    @Delete("delete from com_info where com_id=#{com_id}")
    Integer deleteCompany(String com_id);

    @Select("select * from com_info where com_id=#{com_id}")
    Company getCompanyById(String com_id);

    @Update("update com_info set com_name=#{com_name},com_pwd=#{com_pwd},com_email=#{com_email},com_address=#{com_address},com_identify=#{com_identify} where com_id=#{com_id}")
    Integer updateCompanyById(Company company);

    @Update("update com_info set com_privilege=#{com_privilege} where com_id=#{com_id}")
    Integer updateCompanyPirvilege(String com_id,Integer com_privilege);
}
