package cn.kgc.tangcco.service;

import java.util.List;

import cn.kgc.tangcco.dao.RoleDao;
import cn.kgc.tangcco.dao.impl.RoleDaoImpl;
import cn.kgc.tangcco.entity.Role;

public class RoleServiceImpl implements RoleService {
     RoleDao roleDao=new RoleDaoImpl();
	@Override
	public List<Role> findUserRoleList(Integer userId) {
		return roleDao.getRoleListByUserId(userId);
	}

}
