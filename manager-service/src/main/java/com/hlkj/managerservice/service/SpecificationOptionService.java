package com.hlkj.managerservice.service;

import com.hlkj.common.utils.PageResult;
import com.hlkj.pojo.model.SpecificationOption;


import java.util.List;

/**
 * SpecificationOption服务接口
 */
public interface SpecificationOptionService {
    List<SpecificationOption> findAll();
    Integer add(SpecificationOption entity);
    SpecificationOption findOne(Long id);
    int update(SpecificationOption entity);
    int delete(Long [] ids);
    PageResult findPage(int pageNum, int pageSize);
    PageResult findPage(int pageNum, int pageSize, SpecificationOption entity);
}
