package com.hlkj.managerweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class TbBrander {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/showBrands")
    public String hello() throws IOException {
        return restTemplate.getForObject("http://cart-service/showBrands",String.class);
    }
}
