package com.hlkj.portalweb.controller;


import com.hlkj.common.utils.Result;
import com.hlkj.pojo.model.Brand;
import com.hlkj.pojo.model.Goods;
import com.hlkj.portalweb.feign.GoodsFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GoodsController {

    @Autowired
    GoodsFeignClient goodsFeignClient;

    //查询所有的方法
    @GetMapping("/admin/brand/findAll")
    public String hello() throws IOException {
        return "";
    }
    //增加的方法
    @PostMapping("/admin/brand/add")
    public Result add(@RequestBody Goods entity){
        return goodsFeignClient.add(entity);
    }
}
