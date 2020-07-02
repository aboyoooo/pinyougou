package com.hlkj.sellgoodsservice.controller;

import com.hlkj.common.utils.Result;
import com.hlkj.pojo.model.Goods;
import com.hlkj.sellgoodsservice.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @PostMapping("/add")
    public Result add(Goods goods){
        int ret=goodsService.add(goods);
        if(ret>0){
            return new Result(true, "插入成功");
        }else {
            return new Result(false, "插入失败");
       }
    }
}
