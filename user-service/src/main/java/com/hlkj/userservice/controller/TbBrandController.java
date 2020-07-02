package com.hlkj.managerservice.controller;

import com.hlkj.managerservice.service.TbBrandService;
import com.hlkj.pojo.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TbBrand的controller，给其它服务提供使用
 */
@RestController
public class TbBrandController {
    @Autowired
    private TbBrandService tbBrandService;
    @GetMapping(value = "/getAllBrands")
    public List<Brand> getAllBrands(){
        return tbBrandService.findAllBrands();
    };
    @PostMapping("/addBrand")
    public Integer addBrand(@RequestBody Brand entity){
        //数据
        return tbBrandService.addBrand(entity);
    }
}
