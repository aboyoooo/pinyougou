package com.hlkj.portalweb.feign;

import com.hlkj.common.utils.Result;
import com.hlkj.pojo.model.Brand;
import com.hlkj.pojo.model.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(value = "sellgoods-service")
public interface GoodsFeignClient {
    @GetMapping(value = "/getAllBrands")
    String findAllBrands();

    @PostMapping(value = "/goods/add")
    Result add(Goods goods);
}
