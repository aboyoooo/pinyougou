package com.hlkj.managerweb.feign;

import com.hlkj.common.utils.PageResult;
import com.hlkj.pojo.model.Specification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "manager-service")
public interface SpecificationFeignClient {
     /*
   specificationOption类的操作
    */
    @GetMapping(value = "/specification/findAll")
    String findAll();

    @RequestMapping("/specification/findPage")
    PageResult findPage(@RequestParam("page") int pageNum, @RequestParam("rows") int pageSize);

    @PostMapping("/specification/findPage")
    PageResult search(@RequestParam("page") int pageNum, @RequestParam("rows") int pageSize, @RequestBody Specification specification);

    @PostMapping("/specification/add")
    String add(Specification specification);

    @RequestMapping("/specification/findOne")
    Specification findOne(@RequestParam("id") Long id);

    @RequestMapping("/specification/update")
    String update(@RequestBody Specification specification);

    @RequestMapping("/specification/delete")
    void delete(@RequestParam("ids") Long [] ids);

}
