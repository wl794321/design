package com.mmss.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("userController/load")
	public String load(){
	return "login";
	}
	@RequestMapping("userController/login")
	public String login(HttpSession session, String usname, String password){
	return "index";
	}
}
