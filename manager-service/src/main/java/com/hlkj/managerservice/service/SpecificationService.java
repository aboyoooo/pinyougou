package com.hlkj.managerservice.service;

import com.hlkj.common.utils.PageResult;
import com.hlkj.pojo.model.Brand;
import com.hlkj.pojo.model.Specification;

import java.util.List;

public interface SpecificationService {
    List<Specification> findAll();
    Specification findById(Long id);
    Integer add(Specification entity);
    Specification findOne(Long id);
    int update(Specification entity);
    int delete(Long [] ids);
    PageResult findPage(int pageNum, int pageSize);
    public PageResult findPage(int pageNum, int pageSize, Specification entity);
}

