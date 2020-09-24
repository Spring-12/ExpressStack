package com.lcl.service;

import com.lcl.domain.Admin;

import java.util.Date;

public interface AdminService {
    Admin login(Admin admin);

    void updateTimeIp(Date loginTime,String loginIp,Integer id);
}
