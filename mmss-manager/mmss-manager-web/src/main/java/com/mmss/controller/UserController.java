package com.mmss.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mmss.pojo.ActiveUser;
import com.mmss.service.user.UserService;

@Controller
public class UserController {
	// 系统首页
	@RequestMapping("first")
	public String first(Model model) throws Exception {

		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 通过model传到页面
		model.addAttribute("activeUser", activeUser);

		return "/index";
	}

	// 欢迎页面
	@RequestMapping("/welcome")
	public String welcome(Model model) throws Exception {

		return "/welcome";

	}
	
	@RequestMapping("login")
	public String login(HttpServletRequest request)throws Exception{
		
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		//根据shiro返回的异常类路径判断，抛出指定异常信息
		if(exceptionClassName!=null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				//最终会抛给异常处理器
				//throw new CustomException("账号不存在");
				request.setAttribute("shiroLoginFailure", "账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(
					exceptionClassName)) {
				//throw new CustomException("用户名/密码错误");
				request.setAttribute("shiroLoginFailure", "用户名/密码错误");
			} else if("randomCodeError".equals(exceptionClassName)){
				//throw new CustomException("验证码错误 ");
				request.setAttribute("shiroLoginFailure", "验证码错误 ");
			}else {
				throw new Exception();//最终在异常处理器生成未知错误
			}
		}
		//此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		//登陆失败还到login页面
		return "login";
	}
	@RequestMapping("loginout")
	public String loginout(HttpSession session){
		session.invalidate();
		return "redirect:first.do";
	}
}
