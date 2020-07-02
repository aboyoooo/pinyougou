package com.hlkj.managerservice.service;

import com.hlkj.pojo.model.Brand;

import java.util.List;

/**
 * TbBrand服务接口
 */
public interface TbBrandService {
    public List<Brand> findAllBrands();
    public Brand findBrandById(Long id);
}
