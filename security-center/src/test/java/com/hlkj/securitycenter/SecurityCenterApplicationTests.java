package com.hlkj.securitycenter;

import com.hlkj.securitycenter.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SecurityCenterApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.findByUsername("admin"));
    }

}
