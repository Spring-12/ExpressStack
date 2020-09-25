package com.lcl.service.impl;

import com.github.pagehelper.PageHelper;
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

    /**
     * 用于查询：快递总数加今日新增数，待取件快递的总数和今日新增
     *
     * @return
     */
    @Test
    public void console() {
        System.out.println(expressMapper.console());
    }

    /**
     * 根据快递单号查询快递
     *
     * @param exprSno
     * @return 返回null或一个快递
     */
    @Test
    public void getExpressBySno() {
        System.out.println(expressMapper.getExpressBySno("s001"));
    }

    /**
     * 根据收件人号码查询快递
     *
     * @param userPhone
     * @return 返回null或一个或多个
     */
    @Test
    public void getExpressByPhone() {
        System.out.println(expressMapper.getExpressByPhone("13364000032"));
    }

    /**
     * 根据取件码查询快递
     *
     * @param code
     * @return 返回结果为null或一个快递
     */
    @Test
    public void getExpressByCode() {
        System.out.println(expressMapper.getExpressByCode("123"));
    }

    /**
     * 根据录入人手机号查询所有录入记录
     *
     * @param sysPhone
     * @return
     */
    @Test
    public void getExpressBySysPhone() {
        System.out.println(expressMapper.getExpressBySysPhone("110"));
    }

    /**
     * 录入快递
     *
     * @param express
     * @return 如果录入成功，返回快递的id
     */
    @Test
    public void insertExpress() {

    }

    /**
     * 修改快递信息
     *
     * @param id      ：要修改快递的id
     * @param express ：新的快递信息
     */
    @Test
    public void updateExpress() {

    }

    /**
     * 删除快递，实际上是修改快递的状态信息
     *
     * @param id
     */
    @Test
    public void deleteExpress() {

    }
    
}
