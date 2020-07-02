package com.hlkj.managerweb.controller;

import com.hlkj.common.utils.PageResult;
import com.hlkj.common.utils.Result;

import com.hlkj.managerweb.feign.SpecificationOptionFeignClient;
import com.hlkj.pojo.model.SpecificationOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/specificationOption")
public class SpecificationOptionController {

    @Autowired
    SpecificationOptionFeignClient specificationOptionFeignClient;

    @GetMapping("/findAll")
    public String hello() throws IOException {
        return specificationOptionFeignClient.findAll();
    }

    @PostMapping("/search")
    public PageResult search(int page, int rows){
        return findPage(page,rows);
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return specificationOptionFeignClient.findPage(page, rows);
    }

    @PostMapping("/add")
    //@PathVariable用于Restful风格
    public Result add(@RequestBody SpecificationOption entity) {
        try {
            specificationOptionFeignClient.add(entity);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }

    }

    @RequestMapping("/findOne")
    public SpecificationOption findOne(@RequestParam("id") Long id){
        //System.out.println("====="+id);
        return specificationOptionFeignClient.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody SpecificationOption specificationOption) {
        try {
            specificationOptionFeignClient.update(specificationOption);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }

    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            specificationOptionFeignClient.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
