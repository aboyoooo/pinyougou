package com.hlkj.managerweb.feign;

import com.hlkj.common.utils.PageResult;
import com.hlkj.pojo.model.SpecificationOption;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "manager-service")
public interface SpecificationOptionFeignClient {
    /*
   specificationOption类的操作
    */
    @GetMapping(value = "/specificationOption/findAll")
    String findAll();

    @RequestMapping("/specificationOption/findPage")
    PageResult findPage(@RequestParam("page") int pageNum, @RequestParam("rows") int pageSize);

    @PostMapping("/specificationOption/add")
    String add(SpecificationOption specificationOption);

    @RequestMapping("/specificationOption/findOne")
    SpecificationOption findOne(@RequestParam("id") Long id);

    @RequestMapping("/specificationOption/update")
    String update(@RequestBody SpecificationOption specificationOption);

    @RequestMapping("/specificationOption/delete")
    void delete(@RequestParam("ids") Long [] ids);

}
