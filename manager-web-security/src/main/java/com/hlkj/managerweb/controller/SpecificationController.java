package com.hlkj.managerweb.controller;

import com.hlkj.common.utils.PageResult;
import com.hlkj.common.utils.Result;
import com.hlkj.managerweb.feign.SpecificationFeignClient;
import com.hlkj.pojo.model.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Autowired
    SpecificationFeignClient specificationFeignClient;

    @GetMapping("/findAll")
    public String hello() throws IOException {
        return specificationFeignClient.findAll();
    }

//    @PostMapping("/search")
//    public PageResult search(int page, int rows,@RequestBody Specification specification){
//        return specificationFeignClient.search(page,rows, specification);
//    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return specificationFeignClient.findPage(page, rows);
    }

    @RequestMapping("/search")
    public PageResult search(int page, int rows, @RequestBody Specification specification){
        return specificationFeignClient.search(page, rows, specification);
    }

    @PostMapping("/add")
    //@PathVariable用于Restful风格
    public Result add(@RequestBody Specification entity) {
        try {
            specificationFeignClient.add(entity);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }

    }

    @RequestMapping("/findOne")
    public Specification findOne(@RequestParam("id") Long id){
        //System.out.println("====="+id);
        return specificationFeignClient.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Specification specification) {
        try {
            specificationFeignClient.update(specification);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }

    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            specificationFeignClient.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
