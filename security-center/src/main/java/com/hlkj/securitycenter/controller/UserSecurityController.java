package com.hlkj.securitycenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserSecurityController {
    // 自定义登陆页面
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
