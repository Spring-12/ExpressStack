package com.lcl.mapper;

import com.lcl.domain.Express;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface ExpressMapper {

    List<Express> findAll();

}
