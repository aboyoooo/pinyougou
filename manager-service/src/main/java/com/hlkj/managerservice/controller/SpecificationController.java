package com.hlkj.managerservice.controller;

import com.hlkj.common.utils.PageResult;
import com.hlkj.common.utils.Result;
import com.hlkj.managerservice.service.SpecificationService;
import com.hlkj.pojo.model.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Specification的controller，给其它服务提供使用
 */
@RestController
@RequestMapping(value = "/specification")
public class SpecificationController {
    @Autowired
    private SpecificationService specificationService;


    @GetMapping(value = "/findAll")
    public List<Specification> getAllSpecifications(){
        return specificationService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return specificationService.findPage(page, rows);
    }

    @RequestMapping("/search")
    public PageResult search(int page, int rows, @RequestBody Specification specification){
        return specificationService.findPage(page, rows, specification);
    }

    @PostMapping("/add")
    public Result addSpecification(@RequestBody Specification entity){
        try {

            specificationService.add(entity);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }

    }

    @RequestMapping("/findOne")
    public Specification findOne(Long id){
        return specificationService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Specification specification){
        try {
            specificationService.update(specification);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            specificationService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
