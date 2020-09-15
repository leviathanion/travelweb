package com.twentytwo.travelweb.serviceimpl;

import com.twentytwo.travelweb.entity.Admin;
import com.twentytwo.travelweb.mapper.AdminMapper;
import com.twentytwo.travelweb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin getAdminById(String admin_id) {
        return adminMapper.getAdminById(admin_id);
    }
}
