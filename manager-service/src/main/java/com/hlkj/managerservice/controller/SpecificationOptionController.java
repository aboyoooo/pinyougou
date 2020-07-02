package com.hlkj.managerservice.controller;

import com.hlkj.common.utils.PageResult;
import com.hlkj.common.utils.Result;
import com.hlkj.managerservice.service.SpecificationOptionService;
import com.hlkj.pojo.model.SpecificationOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SpecificationOption的controller，给其它服务提供使用
 */
@RestController
@RequestMapping(value = "/specificationOption")
public class SpecificationOptionController {
    @Autowired
    private SpecificationOptionService specificationOptionService;


    @GetMapping(value = "/findAll")
    public List<SpecificationOption> getAllSpecificationOptions(){
        return specificationOptionService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return specificationOptionService.findPage(page, rows);
    }

    @RequestMapping("/search")
    public PageResult search(int page, int rows, @RequestBody SpecificationOption specificationOption){
        return specificationOptionService.findPage(page, rows, specificationOption);
    }

    @PostMapping("/add")
    public Result addSpecificationOption(@RequestBody SpecificationOption entity){
        try {

            specificationOptionService.add(entity);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }

    }

    @RequestMapping("/findOne")
    public SpecificationOption findOne(Long id){
        return specificationOptionService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody SpecificationOption specificationOption){
        try {
            specificationOptionService.update(specificationOption);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            specificationOptionService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
