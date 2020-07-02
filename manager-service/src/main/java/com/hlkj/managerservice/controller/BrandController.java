package com.hlkj.managerservice.controller;

import com.hlkj.managerservice.service.BrandService;
import com.hlkj.common.utils.PageResult;
import com.hlkj.common.utils.Result;
import com.hlkj.pojo.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Brand的controller，给其它服务提供使用
 */
@RestController
@RequestMapping(value = "/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;


    @GetMapping(value = "/findAll")
    public List<Brand> getAllBrands(){
        return brandService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return brandService.findPage(page, rows);
    }

    @PostMapping("/search")
    public PageResult search(int page, int rows, @RequestBody Brand brand){
        return brandService.findPage(page, rows, brand);
    }

    @PostMapping("/add")
    public Result addBrand(@RequestBody Brand entity){
        try {

            brandService.add(entity);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }

    }

    @RequestMapping("/findOne")
    public Brand findOne(Long id){
        return brandService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Brand brand){
        try {
              brandService.update(brand);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            brandService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
