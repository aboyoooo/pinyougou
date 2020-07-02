package com.hlkj.managerservice;

import com.hlkj.managerservice.service.TbBrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@SpringBootTest
class CartServiceApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private TbBrandService tbBrandService;


    @Test
    void contextLoads() {
        //System.out.println(dataSource);
        System.out.println(tbBrandService.findAllBrands());
    }

}
