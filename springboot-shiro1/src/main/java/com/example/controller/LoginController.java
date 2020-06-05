package com.example.controller;

import com.example.common.ActiverUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

	

	/**
	 * 登陆
	 */
	@RequestMapping("login")
	public String login(String username,String password,HttpSession session) {
		//封装token
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		//得到主体
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
			session.setAttribute("user", activerUser.getUser());
			return "redirect:/user/toUserManager";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return "redirect:/index.html";
		}
	}
	
	
	
}
