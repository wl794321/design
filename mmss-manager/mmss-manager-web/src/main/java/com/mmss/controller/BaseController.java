package com.mmss.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.mmss.pojo.ActiveUser;
import com.mmss.pojo.SysUser;
import com.mmss.service.user.UserService;

public class BaseController {
	
	
	 @Autowired
     UserService userService;
	 
	 /**
	  * 获取当前用户
	  * @return
	  */
     public SysUser getCurrentUser(){
    	// 从shiro的session中取activeUser
 		Subject subject = SecurityUtils.getSubject();
 		// 取身份信息
 		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
 		SysUser sysUser = userService.findUserById(activeUser.getUserid());
 		return sysUser;
     }
     /**
      * 获取当前登录用户id
      * @return
      */
     public String getUserId() {
         return this.getCurrentUser().getId();
     }

     /**
      * 获取当前登录用户名
      * @return
      */
     public String getStaffName() {
         return this.getCurrentUser().getUsername();
     }
}
