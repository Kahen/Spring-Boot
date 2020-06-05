package com.example.springboot04webrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 李家幸
 * @class 计科三班
 * @create 2019-12-06 13:22
 */
@Controller
public class LoginController {
    @PostMapping(value = "/user/login")
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }else {
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }
}
