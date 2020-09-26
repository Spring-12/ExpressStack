package com.lcl.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcl.domain.Console;
import com.lcl.domain.Express;
import com.lcl.result.Message;
import com.lcl.service.ExpressService;
import com.lcl.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/express"}, produces = {"application/json; charset=UTF-8"})
public class ExpressController {

    @Autowired
    private ExpressService expressService;

    @RequestMapping(value = {"/findAll"}, method = RequestMethod.POST)
    @ResponseBody
    public String findAll(Integer page, Integer size) {
        List<Express> lists = expressService.findAll(page, size);
        //封装了当前页数据，当前页号，总页号，上一页，下一页等信息
        PageInfo<Express> pageInfo = new PageInfo<>(lists);
        Message message = new Message(0, "查询成功", pageInfo);
        return JSONUtil.toJSON(message);
    }

    @RequestMapping("/insert")
    public void insert(Express express) {
        expressService.insertExpress(express);
    }

    @RequestMapping(value = {"/console"})
    @ResponseBody
    public String console() {
        Console console = expressService.console();
        Message message = new Message(0);
        message.setData(console);
        return JSONUtil.toJSON(message);
    }

    @RequestMapping("/getExpressBySno")
    public String getExpressBySno(String exprSno) {
        Express expressBySno = expressService.getExpressBySno(exprSno);

        return null;
    }

    @RequestMapping("/getExpressByPhone")
    public String getExpressByPhone(String userPhone) {
        List<Express> expressByPhone = expressService.getExpressByPhone(userPhone);

        return null;
    }

    @RequestMapping("/getExpressByCode")
    public String getExpressByCode(String code) {
        Express expressByCode = expressService.getExpressByCode(code);
        return null;
    }

    @RequestMapping("/getExpressBySysPhone")
    public String getExpressBySysPhone(String sysPhone) {
        List<Express> expressBySysPhone = expressService.getExpressBySysPhone(sysPhone);

        return null;
    }

    @RequestMapping("/update")
    public void updateExpress(Integer id,Express express) {
        expressService.updateExpress(id,express);

    }

    public void deleteExpress(Integer id) {
        expressService.deleteExpress(id);

    }


}
