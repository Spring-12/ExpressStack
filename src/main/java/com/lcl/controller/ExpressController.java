package com.lcl.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcl.domain.Console;
import com.lcl.domain.Express;
import com.lcl.domain.PageData;
import com.lcl.result.Message;
import com.lcl.service.ExpressService;
import com.lcl.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/express"}, produces = {"application/json; charset=UTF-8"})
public class ExpressController {

    @Autowired
    private ExpressService expressService;

    @RequestMapping(value = {"/findAll"}, method = RequestMethod.GET)
    @ResponseBody
    public String findAll(HttpServletRequest request) {
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        List<Express> lists = expressService.findAll(page, size);
        //封装了当前页数据，当前页号，总页号，上一页，下一页等信息
        PageInfo<Express> pageInfo = new PageInfo<>(lists);
        //匹配前端分页组件
        PageData<Express> pageList = new PageData<>();
        pageList.setPageData(pageInfo.getList());
        pageList.setTotal((int) pageInfo.getTotal());
        Message message = new Message(0, "查询成功", pageList);
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
    @ResponseBody
    public String getExpressBySno(String exprSno) {
        Express expressBySno = expressService.getExpressBySno(exprSno);
        Message message = new Message();
        if (expressBySno == null) {
            message.setStatus(-1);
            message.setResult("没有订单号为：" + exprSno + ",的订单");
        } else {
            message.setStatus(0);
            message.setResult("查询成功");
            message.setData(expressBySno);
        }
        return JSONUtil.toJSON(message);
    }

    @RequestMapping("/getExpressByPhone")
    @ResponseBody
    public String getExpressByPhone(String userPhone) {
        List<Express> expressByPhone = expressService.getExpressByPhone(userPhone);
        Message message = new Message();
        if (expressByPhone == null || expressByPhone.size() == 0) {
            message.setStatus(-1);
            message.setResult("该手机号没有快递");
        } else {
            message.setStatus(0);
            message.setResult("查询成功");
            message.setData(expressByPhone);
        }
        return JSONUtil.toJSON(message);
    }

    @RequestMapping("/getExpressByCode")
    @ResponseBody
    public String getExpressByCode(String code) {
        Express expressByCode = expressService.getExpressByCode(code);
        Message message = new Message();
        if (expressByCode == null) {
            message.setStatus(-1);
            message.setResult("查询不到结果");
        } else {
            message.setStatus(0);
            message.setResult("查询成功");
            message.setData(expressByCode);
        }
        return JSONUtil.toJSON(message);
    }

    @RequestMapping("/getExpressBySysPhone")
    @ResponseBody
    public String getExpressBySysPhone(String sysPhone) {
        List<Express> expressBySysPhone = expressService.getExpressBySysPhone(sysPhone);
        Message message = new Message();
        if (expressBySysPhone == null || expressBySysPhone.size() == 0) {
            message.setStatus(-1);
            message.setResult("该快递员暂时还未录入快递");
        } else {
            message.setStatus(0);
            message.setData(expressBySysPhone);
        }
        return JSONUtil.toJSON(message);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateExpress(Integer id, Express express) {
        expressService.updateExpress(id, express);
        Message message = new Message(0,"删除成功");
        return JSONUtil.toJSON(message);
    }

    @RequestMapping("/delete")
    public void deleteExpress(Integer id) {
        expressService.deleteExpress(id);

    }


}
