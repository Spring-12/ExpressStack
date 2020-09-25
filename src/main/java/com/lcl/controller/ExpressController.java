package com.lcl.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @RequestMapping(value = {"/findAll/{page}/{size}"}, method = RequestMethod.GET)
    @ResponseBody
    public String findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        List<Express> lists = expressService.findAll(page, size);
        //封装了当前页数据，当前页号，总页号，上一页，下一页等信息
        PageInfo<Express> pageInfo = new PageInfo<>(lists);
        Message message = new Message(0, "查询成功", pageInfo);
        return JSONUtil.toJSON(message);
    }

    public void insert() {
       
    }

}
