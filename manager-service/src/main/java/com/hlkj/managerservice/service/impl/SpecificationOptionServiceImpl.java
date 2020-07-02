package com.hlkj.managerservice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hlkj.common.utils.PageResult;
import com.hlkj.managerservice.mapper.SpecificationMapper;
import com.hlkj.managerservice.mapper.SpecificationOptionMapper;
import com.hlkj.managerservice.service.SpecificationOptionService;
import com.hlkj.pojo.model.SpecificationOption;
import com.hlkj.pojo.model.SpecificationOptionExample;
import com.hlkj.pojo.model.SpecificationOptionExample.Criteria;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {
    @Resource
    private SpecificationOptionMapper specificationOptionMapper;


    @Override
    public List<SpecificationOption> findAll() {
        return specificationOptionMapper.selectByExample(null);
    }

    @Override
    public Integer add(SpecificationOption entity) {
        return specificationOptionMapper.insert(entity);
    }

    @Override
    public SpecificationOption findOne(Long id) {
        //System.out.println("--------"+id);
        return specificationOptionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(SpecificationOption entity) {
        return specificationOptionMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int delete(Long[] ids) {
        for(Long id:ids){
            System.out.println("-----"+id);
        }
        for(Long id:ids){
            specificationOptionMapper.deleteByPrimaryKey(id);
        }
        return ids.length;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<SpecificationOption> page = (Page<SpecificationOption>)specificationOptionMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }
    @Override
    public PageResult findPage(int pageNum, int pageSize, SpecificationOption entity) {
        //分页查询
        PageHelper.startPage(pageNum,pageSize);
        //构建查询条件
        SpecificationOptionExample example=null;
        Criteria criteria=null;
        if(entity!=null) {
            example = new SpecificationOptionExample();
            if(entity.getOptionName()!=null&&entity.getOptionName()!=""){
                criteria.andOptionNameLike(entity.getOptionName());
            }
         }
        //查询
        Page<SpecificationOption> page = (Page<SpecificationOption>)specificationOptionMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
