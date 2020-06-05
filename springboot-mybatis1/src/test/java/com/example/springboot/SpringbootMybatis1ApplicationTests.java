package com.example.springboot;


import com.example.springboot.domain.User;
import com.example.springboot.mapper.UserMapper;
import com.github.aidensuen.mongo.pagehelper.Page;
import com.github.aidensuen.mongo.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatis1ApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(userMapper);
        List<User> users = userMapper.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    void page(){
        Page<Object> page= PageHelper.startPage(1,2);
        List<User> users=userMapper.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("总条数"+page.getTotal());
    }
}
