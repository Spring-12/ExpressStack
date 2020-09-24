package com.lcl.mapper;

import com.lcl.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.Date;

@MapperScan
public interface AdminMapper {

    Admin login(Admin admin);

    void updateTimeIp(@Param("loginTime") Date loginTime, @Param("loginIp") String loginIp,@Param("id") Integer id);
}
