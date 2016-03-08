package com.mmss.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmss.pojo.ActiveUser;

@Controller
public class AuthController {
	@RequestMapping("authorization")
	public String authorization(Model model) {
		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 通过model传到页面
		model.addAttribute("activeUser", activeUser);
		return "admin/authorization";
	}
}
