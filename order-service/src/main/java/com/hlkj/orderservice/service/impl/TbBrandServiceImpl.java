package com.hlkj.managerservice.service.impl;

import com.hlkj.managerservice.mapper.TbBrandMapper;
import com.hlkj.managerservice.service.TbBrandService;
import com.hlkj.pojo.model.Brand;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TbBrandServiceImpl implements TbBrandService {
    @Resource
    private TbBrandMapper tbBrandMapper;
    @Override
    public List<Brand> findAllBrands() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public Brand findBrandById(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addBrand(Brand brand) {
        return tbBrandMapper.insert(brand);
    }
}
