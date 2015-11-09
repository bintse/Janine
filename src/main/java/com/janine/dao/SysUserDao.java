package com.janine.dao;

import java.util.List;

import com.janine.entity.SysUser;

public interface SysUserDao  {
	public List<SysUser> findAllUser();
}
