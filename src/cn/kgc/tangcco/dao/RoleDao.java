package cn.kgc.tangcco.dao;

import java.util.List;

import cn.kgc.tangcco.entity.Role;

public interface RoleDao {
   List<Role> getRoleListByUserId(Integer userId);
}
