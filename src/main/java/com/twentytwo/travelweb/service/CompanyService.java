package com.twentytwo.travelweb.service;

import com.twentytwo.travelweb.entity.Company;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Integer addCompany(Company company);
    Integer deleteCompany(String com_id);
    Company getCompanyById(String com_id);
    Integer updateCompanyById(Company company);
    Integer updateCompanyPirvilege(String com_id,Integer com_privilege);
}
