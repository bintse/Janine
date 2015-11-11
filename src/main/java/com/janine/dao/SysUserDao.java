package com.janine.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.janine.entity.SysUser;


public interface SysUserDao extends PagingAndSortingRepository<SysUser, String>, JpaSpecificationExecutor<SysUser>  {
	List<SysUser> findAllUser();
	
	//SysUser findByUserName(String username);
}
