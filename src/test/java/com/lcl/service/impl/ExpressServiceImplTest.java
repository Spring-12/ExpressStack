package com.lcl.service.impl;

import com.lcl.mapper.ExpressMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ExpressServiceImplTest {

    @Autowired
    private ExpressMapper expressMapper;

    @Test
    public void findAll() {
        System.out.println(expressMapper.findAll());
    }


    @Test
    public void console() {
        System.out.println(expressMapper.console());
    }


    @Test
    public void getExpressBySno() {
        System.out.println(expressMapper.getExpressBySno("s001"));
    }


    @Test
    public void getExpressByPhone() {
        System.out.println(expressMapper.getExpressByPhone("13364000032"));
    }


    @Test
    public void getExpressByCode() {
        System.out.println(expressMapper.getExpressByCode("123"));
    }


    @Test
    public void getExpressBySysPhone() {
        System.out.println(expressMapper.getExpressBySysPhone("110"));
    }


    @Test
    public void insertExpress() {

    }


    @Test
    public void updateExpress() {

    }


    @Test
    public void deleteExpress() {

    }

}
