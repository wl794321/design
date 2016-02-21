package com.mmss.service.user;

import java.util.List;

import com.mmss.pojo.SysPermission;
import com.mmss.pojo.SysUser;
import com.mmss.pojo.SysUserQueryModel;

public interface UserService {

	SysUser findSysUserByUserCode(String userCode);

	List<SysPermission> findMenuListByUserId(String id) throws Exception;

	List<SysPermission> findPermissionListByUserId(String userid) throws Exception;

	List<SysUser> getByConditionPage(SysUserQueryModel sysUserQueryModel);
}
