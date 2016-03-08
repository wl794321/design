package com.mmss.service.impl.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmss.mapper.SysPermissionMapperCustom;
import com.mmss.mapper.SysUserMapper;
import com.mmss.pojo.SysPermission;
import com.mmss.pojo.SysUser;
import com.mmss.pojo.SysUserExample;
import com.mmss.pojo.SysUserQueryModel;
import com.mmss.service.user.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysPermissionMapperCustom sysPermissionMapperCustom;

	@Override
	public SysUser findSysUserByUserCode(String userCode) {
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(userCode);

		List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);

		if (list != null && list.size() == 1) {
			return list.get(0);
		}

		return null;
	}

	@Override
	public List<SysPermission> findMenuListByUserId(String id) throws Exception {
		return sysPermissionMapperCustom.findMenuListByUserId(id);
	}

	@Override
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception {
		return sysPermissionMapperCustom.findPermissionListByUserId(userid);
	}

	@Override
	public List<SysUser> getByConditionPage(SysUserQueryModel sysUserQueryModel) {
		// TODO Auto-generated method stub
		return sysUserMapper.getByConditionPage(sysUserQueryModel);
	}

	@Override
	public SysUser findUserById(String userid) {
		// TODO Auto-generated method stub
		return sysUserMapper.findUserById(userid);
	}

}
