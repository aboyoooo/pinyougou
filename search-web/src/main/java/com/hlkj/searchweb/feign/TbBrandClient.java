package com.hlkj.managerweb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "cart-service")
public interface TbBrandClient {
    @RequestMapping(value = "/getAllBrands")
    String findAllBrands();
}
