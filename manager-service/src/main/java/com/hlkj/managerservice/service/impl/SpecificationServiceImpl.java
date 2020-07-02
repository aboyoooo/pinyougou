package com.hlkj.managerservice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hlkj.common.utils.PageResult;
import com.hlkj.managerservice.mapper.SpecificationMapper;
import com.hlkj.managerservice.service.SpecificationService;
import com.hlkj.pojo.model.Brand;
import com.hlkj.pojo.model.Specification;
import com.hlkj.pojo.model.SpecificationExample;
import com.hlkj.pojo.model.SpecificationExample.Criteria;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Resource
    private SpecificationMapper specificationMapper;


    @Override
    public List<Specification> findAll() {
        return specificationMapper.selectByExample(null);
    }

    @Override
    public Specification findById(Long id) {
        return specificationMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer add(Specification entity) {
        return specificationMapper.insert(entity);
    }

    @Override
    public Specification findOne(Long id) {
        return specificationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Specification entity) {
        return specificationMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int delete(Long[] ids) {
        for(Long id:ids){
            System.out.println("-----"+id);
        }
        for(Long id:ids){
            specificationMapper.deleteByPrimaryKey(id);
        }
        return ids.length;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Specification> page = (Page<Specification>)specificationMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }
    @Override
    public PageResult findPage(int pageNum, int pageSize, Specification entity) {
        //分页查询
        PageHelper.startPage(pageNum,pageSize);
        //构建查询条件
        SpecificationExample example=null;
        Criteria criteria=null;
        if(entity!=null) {
            example = new SpecificationExample();
            if(entity.getSpecName()!=null&&entity.getSpecName()!=""){
                criteria.andSpecNameLike("%"+entity.getSpecName()+"%");
            }
         }
        //查询
        Page<Specification> page = (Page<Specification>)specificationMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
