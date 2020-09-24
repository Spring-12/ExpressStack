package com.lcl.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lcl.domain.Express;
import com.lcl.mapper.ExpressMapper;
import com.lcl.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private ExpressMapper expressMapper;

    @Override
    public List<Express> findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return expressMapper.findAll();
    }

}
