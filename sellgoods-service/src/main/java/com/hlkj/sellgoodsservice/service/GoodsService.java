package com.hlkj.sellgoodsservice.service;

import com.hlkj.pojo.model.Brand;
import com.hlkj.pojo.model.Goods;

import java.util.List;

/**
 * TbBrand服务接口
 */
public interface GoodsService {
    public List<Brand> findAllBrands();
    public Brand findBrandById(Long id);
    public int add(Goods goods);
}
