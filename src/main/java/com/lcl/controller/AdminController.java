package com.lcl.controller;

import com.lcl.domain.Admin;
import com.lcl.result.Message;
import com.lcl.service.AdminService;
import com.lcl.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(Admin admin, @RequestBody HttpServletRequest request) {
        Admin adm = adminService.login(admin);
        Message message = null;
        if (adm != null) {
            //更新登录时间和登录ip
            String loginIp = request.getRemoteAddr();
            adminService.updateTimeIp(new Date(), loginIp, adm.getId());
            message = new Message(0, "登录成功", adm.getUserName());
            return JSONUtil.toJSON(message);
        }
        return JSONUtil.toJSON(new Message(-1, "登录失败"));
    }

}
