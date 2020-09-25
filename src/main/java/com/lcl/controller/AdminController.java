package com.lcl.controller;

import com.lcl.domain.Admin;
import com.lcl.result.Message;
import com.lcl.service.AdminService;
import com.lcl.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String login(Admin admin, HttpServletRequest request) {
        Admin adm = adminService.login(admin);
        Message message = null;
        if (adm != null) {
            //更新登录时间和登录ip
            String loginIp = request.getRemoteAddr();
            adminService.updateTimeIp(new Date(), loginIp, adm.getId());
            message = new Message(0, "登录成功", adm.getUserName());

            //保存session
            HttpSession session = request.getSession();
            session.setAttribute("username",adm.getUserName());
            return JSONUtil.toJSON(message);
        }
        return JSONUtil.toJSON(new Message(-1, "登录失败"));
    }

}
