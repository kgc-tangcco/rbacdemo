package cn.kgc.tangcco.service;

import java.util.List;

import cn.kgc.tangcco.entity.Role;

public interface RoleService {
	//查询没有的角色
	 	List<Role> findUserRoleList(Integer userId);
}
