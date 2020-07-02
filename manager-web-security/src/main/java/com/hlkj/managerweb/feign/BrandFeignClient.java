package com.hlkj.managerweb.feign;

import com.hlkj.common.utils.PageResult;
import com.hlkj.pojo.model.Brand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "manager-service")
public interface BrandFeignClient {
    /*
brand类的操作
*/
    @GetMapping(value = "/brand/findAll")
    String findAll();

    @RequestMapping("/brand/findPage")
    PageResult findPage(@RequestParam("page") int pageNum, @RequestParam("rows") int pageSize);

    @PostMapping("/brand/search")
    PageResult search(@RequestParam("page") int pageNum, @RequestParam("rows") int pageSize, @RequestBody Brand brand);

    @PostMapping("/brand/add")
    String add(Brand brand);

    @RequestMapping("/brand/findOne")
    Brand findOne(@RequestParam("id") Long id);

    @RequestMapping("/brand/update")
    String update(@RequestBody Brand brand);

    @RequestMapping("/brand/delete")
    void delete(@RequestParam("ids") Long [] ids);
}
