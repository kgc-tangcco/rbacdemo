package cn.kgc.tangcco.service;

import java.util.List;

import cn.kgc.tangcco.entity.Role;

public interface RoleService {
	//��ѯû�еĽ�ɫ
	 	List<Role> findUserRoleList(Integer userId);
}
