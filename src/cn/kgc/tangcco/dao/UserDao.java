package cn.kgc.tangcco.dao;

import java.util.List;

import cn.kgc.tangcco.entity.User;

public interface UserDao {
	//根据用户名查询用户
    User getUserByNameAndPwd(String userName);
    //查询所有的用户
    List<User> getAllUser();
}
