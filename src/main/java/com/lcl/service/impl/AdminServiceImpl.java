package com.lcl.service.impl;

import com.lcl.domain.Admin;
import com.lcl.mapper.AdminMapper;
import com.lcl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        return adminMapper.login(admin);
    }

    @Override
    public void updateTimeIp(Date loginTime, String loginIp, Integer id) {
        adminMapper.updateTimeIp(loginTime, loginIp, id);
    }

}
