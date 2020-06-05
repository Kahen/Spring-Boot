package com.example.springboot04webrestfulcrud.controller;

import com.example.springboot04webrestfulcrud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author 李家幸
 * @class 计科三班
 * @create 2019-12-04 10:52
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if ("aaa".equals(user)) {
            throw new UserNotExistException();
        }
        return "hello";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "你好");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }

}
