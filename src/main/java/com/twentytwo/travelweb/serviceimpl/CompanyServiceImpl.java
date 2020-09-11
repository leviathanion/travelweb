package com.twentytwo.travelweb.serviceimpl;

import com.twentytwo.travelweb.entity.Company;
import com.twentytwo.travelweb.mapper.CompanyMapper;
import com.twentytwo.travelweb.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public List<Company> getAllCompanies() {
        return companyMapper.getAllCompanies();
    }

    @Override
    public Integer addCompany(Company company) {
        return companyMapper.addCompany(company);
    }

    @Override
    public Integer deleteCompany(Integer com_id) {
        return companyMapper.deleteCompany(com_id);
    }

    @Override
    public Company getCompanyById(Integer com_id) {
        return companyMapper.getCompanyById(com_id);
    }

    @Override
    public Integer updateCompanyById(Company company) {
        return companyMapper.updateCompanyById(company);
    }

    @Override
    public Integer updateCompanyPirvilege(Integer com_id, Integer com_privilege) {
        return companyMapper.updateCompanyPirvilege(com_id,com_privilege);
    }
}
