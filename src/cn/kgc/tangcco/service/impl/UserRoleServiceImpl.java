package cn.kgc.tangcco.service.impl;

import java.util.List;

import cn.kgc.tangcco.dao.UserRoleDao;
import cn.kgc.tangcco.dao.impl.UserRoleDaoImpl;
import cn.kgc.tangcco.entity.UserRole;
import cn.kgc.tangcco.service.UserRoleService;

public class UserRoleServiceImpl implements UserRoleService {
    
	private UserRoleDao userRoleDao=new UserRoleDaoImpl();
	/**
	 * �����û���Ų�ѯ�û���ɫid
	 */
	@Override
	public Integer findRoleId(Integer userId) {
		return userRoleDao.getUserRoleId(userId);
	}
	@Override
	public boolean saveUserRole(UserRole userRole) {
		return userRoleDao.addUserRole(userRole)>0?true:false;
	}
	

}
