package cn.kgc.tangcco.dao;

import java.util.List;

import cn.kgc.tangcco.entity.UserRole;

public interface UserRoleDao {
   //�����û�id��ѯ�û���ɫid
	Integer getUserRoleId(Integer userId);
	//���
	Integer addUserRole(UserRole userRole);
	//��ѯû�еĽ�ɫ
	List<UserRole> getUserRoleList(Integer userId);
}
