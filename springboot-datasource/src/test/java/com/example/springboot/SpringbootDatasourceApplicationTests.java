package com.example.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class SpringbootDatasourceApplicationTests {
    @Autowired
    // DataSource dataSource;
    DruidDataSource druidDataSource;

    @Test
    void contextLoads() {
        System.out.println(druidDataSource);
        // System.out.println(dataSource);
    }

}
