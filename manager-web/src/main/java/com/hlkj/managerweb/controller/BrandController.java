package com.hlkj.managerweb.controller;

import com.hlkj.common.utils.PageResult;
import com.hlkj.common.utils.Result;
import com.hlkj.pojo.model.Brand;
import com.hlkj.managerweb.feign.BrandFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/brand")
public class BrandController {


    @Autowired
    BrandFeignClient brandFeignClient;

    @GetMapping("/findAll")
    public String hello() throws IOException {
        return brandFeignClient.findAll();
    }

    @PostMapping("/search")
    public PageResult search(int page, int rows,@RequestBody Brand brand){
        return brandFeignClient.search(page,rows,brand);
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return brandFeignClient.findPage(page, rows);
    }

    @PostMapping("/add")
    //@PathVariable用于Restful风格
    public Result addBrand(@RequestBody Brand entity) {
        try {
            brandFeignClient.add(entity);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }

    }

    @RequestMapping("/findOne")
    public Brand findOne(@RequestParam("id") Long id){
        //System.out.println("====="+id);
        return brandFeignClient.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Brand brand) {
        try {
            System.out.println("--------------brandname : "+brand.getName()+"----------------");
            brandFeignClient.update(brand);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }

    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            brandFeignClient.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
