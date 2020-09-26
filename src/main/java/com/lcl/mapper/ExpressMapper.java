package com.lcl.mapper;

import com.lcl.domain.Console;
import com.lcl.domain.Express;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

@MapperScan
public interface ExpressMapper {

    List<Express> findAll();

    /**
     * 用于查询：快递总数加今日新增数，待取件快递的总数和今日新增
     *
     * @return
     */
    List<Console> console();

    /**
     * 根据快递单号查询快递
     *
     * @param exprSno
     * @return 返回null或一个快递
     */
    Express getExpressBySno(String exprSno);

    /**
     * 根据收件人号码查询快递
     *
     * @param userPhone
     * @return 返回null或一个或多个
     */
    List<Express> getExpressByPhone(String userPhone);

    /**
     * 根据取件码查询快递
     *
     * @param code
     * @return 返回结果为null或一个快递
     */
    Express getExpressByCode(String code);

    /**
     * 根据录入人手机号查询所有录入记录
     *
     * @param sysPhone
     * @return
     */
    List<Express> getExpressBySysPhone(String sysPhone);

    /**
     * 录入快递
     *
     * @param express
     * @return 如果录入成功，返回快递的id
     */
    Integer insertExpress(Express express);

    /**
     * 修改快递信息
     * @param id ：要修改快递的id
     * @param express ：新的快递信息
     */
    void updateExpress(@Param("id") Integer id, @Param("express") Express express);

    /**
     * 删除快递，实际上是修改快递的状态信息
     *
     * @param id
     */
    void deleteExpress(Integer id);

    Express getExpressById(Integer id);
}
