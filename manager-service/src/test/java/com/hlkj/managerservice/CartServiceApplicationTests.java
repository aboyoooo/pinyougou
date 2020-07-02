package com.hlkj.managerservice;

import com.hlkj.managerservice.service.BrandService;
import com.hlkj.managerservice.service.SpecificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class CartServiceApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private SpecificationService specificationService;
    @Autowired
    private BrandService brandService;


    @Test
    void contextLoads() {
        //System.out.println(dataSource);
        System.out.println(brandService.findAll());
    }

}
