package com.hlkj.managerservice.service;

import com.hlkj.common.utils.PageResult;
import com.hlkj.pojo.model.Brand;

import java.util.List;

/**
 * TbBrand服务接口
 */
public interface BrandService {
    List<Brand> findAll();
    Brand findById(Long id);
    Integer add(Brand brand);
    Brand findOne(Long id);
    int update(Brand brand);
    int delete(Long [] ids);
    PageResult findPage(int pageNum, int pageSize);
    PageResult findPage(int pageNum, int pageSize, Brand brand);
}
