package com.lcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.lcl.domain.Console;
import com.lcl.domain.Express;
import com.lcl.mapper.ExpressMapper;
import com.lcl.service.ExpressService;
import com.lcl.utils.CodeUtil;
import com.lcl.utils.SMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    /**
     * 用于查询：快递总数加今日新增数，待取件快递的总数和今日新增
     *
     * @return
     */
    @Override
    public Console console() {
        return expressMapper.console();
    }

    /**
     * 根据快递单号查询快递
     *
     * @param exprSno
     * @return 返回null或一个快递
     */
    @Override
    public Express getExpressBySno(String exprSno) {
        return expressMapper.getExpressBySno(exprSno);
    }

    /**
     * 根据收件人号码查询快递
     *
     * @param userPhone
     * @return 返回null或一个或多个
     */
    @Override
    public List<Express> getExpressByPhone(String userPhone) {
        return expressMapper.getExpressBySysPhone(userPhone);
    }

    /**
     * 根据取件码查询快递
     *
     * @param code
     * @return 返回结果为null或一个快递
     */
    @Override
    public Express getExpressByCode(String code) {
        return expressMapper.getExpressByCode(code);
    }

    /**
     * 根据录入人手机号查询所有录入记录
     *
     * @param sysPhone
     * @return
     */
    @Override
    public List<Express> getExpressBySysPhone(String sysPhone) {
        return expressMapper.getExpressBySysPhone(sysPhone);
    }

    /**
     * 录入快递
     *
     * @param express
     * @return 如果录入成功，返回快递的id
     */
    @Override
    public Integer insertExpress(Express express) {
        //插入快递时生成取件码和快递入栈时间
        String code = CodeUtil.createCode();
        Date inTime = new Date();
        //生成的取件码不能与栈内的快递重复，重复需要再次生成
        if (getExpressByCode(code) == null) {
            express.setCode(code);
            express.setInTime(inTime);
        } else
            insertExpress(express);
        //入栈完成需要给收件人发送验证码
        SMSUtil.send(express.getUserPhone(), code);
        return expressMapper.insertExpress(express);
    }

    /**
     * 修改快递信息
     *
     * @param id      ：要修改快递的id
     * @param express ：新的快递信息
     */
    @Override
    public void updateExpress(Integer id, Express express) {
        Express expressById = expressMapper.getExpressById(id);
        expressMapper.updateExpress(id, express);
        //如果手机号修改需要发送新的取件码
        if (!expressById.getUserPhone().equals(express.getUserPhone()) && express.getExprStatus() == 0) {
            String code = null;
            while (true){
                 code = CodeUtil.createCode();
                Express expressByCode = getExpressByCode(code);
                if (expressByCode==null)
                    break;
            }
            //发送取件码
            SMSUtil.send(express.getUserPhone(),code);
        }

    }

    /**
     * 删除快递，实际上是修改快递的状态信息
     *
     * @param id
     */
    @Override
    public void deleteExpress(Integer id) {
        expressMapper.deleteExpress(id);
    }


}
