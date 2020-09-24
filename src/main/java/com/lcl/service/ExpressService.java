package com.lcl.service;

import com.lcl.domain.Express;

import java.util.List;

public interface ExpressService {

    List<Express> findAll(Integer page, Integer size);

}
