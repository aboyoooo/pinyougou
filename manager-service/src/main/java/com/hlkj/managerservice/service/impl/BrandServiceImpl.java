package com.hlkj.managerservice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hlkj.managerservice.mapper.BrandMapper;
import com.hlkj.managerservice.service.BrandService;
import com.hlkj.common.utils.PageResult;
import com.hlkj.pojo.model.Brand;
import com.hlkj.pojo.model.BrandExample;
import com.hlkj.pojo.model.BrandExample.Criteria;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandMapper brandMapper;


    @Override
    public List<Brand> findAll() {
        return brandMapper.selectByExample(null);
    }

    @Override
    public Brand findById(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer add(Brand brand) {
        return brandMapper.insert(brand);
    }

    @Override
    public Brand findOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Brand brand) {
        return brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public int delete(Long[] ids) {
        for(Long id:ids){
            System.out.println("-----"+id);
        }
        for(Long id:ids){
            brandMapper.deleteByPrimaryKey(id);
        }
        return ids.length;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Brand> page = (Page<Brand>)brandMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize, Brand brand) {
        //分页查询
        PageHelper.startPage(pageNum,pageSize);
        //构建查询条件
        BrandExample example=null;
        Criteria criteria=null;
        if(brand!=null) {
            example = new BrandExample();
            criteria=example.createCriteria();
            if(brand.getName()!=null&&brand.getName()!=""){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if(brand.getFirstChar()!=null&&brand.getFirstChar()!=""){
                criteria.andFirstCharLike(brand.getFirstChar());
            }
        }
        //查询
        Page<Brand> page = (Page<Brand>)brandMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
