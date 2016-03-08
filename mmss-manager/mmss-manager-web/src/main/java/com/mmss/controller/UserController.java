package com.mmss.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.naming.ldap.ManageReferralControl;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmss.pageutils.Page;
import com.mmss.pojo.ActiveUser;
import com.mmss.pojo.SysUser;
import com.mmss.pojo.SysUserQueryModel;
import com.mmss.service.user.UserService;

@Controller
public class UserController extends BaseController {
	@Resource
	UserService userService;	
	
	
	@RequestMapping("userController/manager")
	public String manager(){
		return "admin/user";
	}
	
	
	@RequestMapping("list")
	public String list(){
	  SysUserQueryModel sysUserQueryModel = new SysUserQueryModel();
	  sysUserQueryModel.getPage().setNowPage(0);
	  sysUserQueryModel.getPage().setPageShow(2);
	  List<SysUser> list = userService.getByConditionPage(sysUserQueryModel);
	  sysUserQueryModel.getPage().setRows(list);
		System.out.println(list);
		System.out.println(sysUserQueryModel.getPage().getTotalCount());
		System.out.println(sysUserQueryModel.getPage().getNowPage());
		System.out.println(sysUserQueryModel.getPage().getStart());
		System.out.println(sysUserQueryModel.getPage().getTotalPage());
		
		System.out.println(sysUserQueryModel.getPage().getRows());
	return "/index";
	}
}
