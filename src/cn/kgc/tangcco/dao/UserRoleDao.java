package cn.kgc.tangcco.dao;

import java.util.List;

import cn.kgc.tangcco.entity.UserRole;

public interface UserRoleDao {
   //根据用户id查询用户角色id
	Integer getUserRoleId(Integer userId);
	//添加
	Integer addUserRole(UserRole userRole);
	//查询没有的角色
	List<UserRole> getUserRoleList(Integer userId);
}
