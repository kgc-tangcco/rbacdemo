package cn.kgc.tangcco.service;


import cn.kgc.tangcco.entity.UserRole;

public interface UserRoleService {
   Integer findRoleId(Integer userId);
   boolean saveUserRole(UserRole userRole);
 
}
