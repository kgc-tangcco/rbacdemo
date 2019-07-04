package cn.kgc.tangcco.service;

import java.util.List;

import cn.kgc.tangcco.entity.User;

public interface UserService {
   User login(String userName,String password,Integer roleId);
   List<User> findAllUser();
}
