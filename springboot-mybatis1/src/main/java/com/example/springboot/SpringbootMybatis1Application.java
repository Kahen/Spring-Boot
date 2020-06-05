package com.example.springboot;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@MapperScan(basePackages = {"com.example.springboot.mapper"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootMybatis1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatis1Application.class, args);
    }

}
