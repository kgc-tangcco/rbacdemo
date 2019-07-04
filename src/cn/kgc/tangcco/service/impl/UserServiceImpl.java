package cn.kgc.tangcco.service.impl;

import java.util.List;

import cn.kgc.tangcco.dao.UserDao;
import cn.kgc.tangcco.dao.UserRoleDao;
import cn.kgc.tangcco.dao.impl.UserDaoImpl;
import cn.kgc.tangcco.dao.impl.UserRoleDaoImpl;
import cn.kgc.tangcco.entity.User;
import cn.kgc.tangcco.service.UserService;

public class UserServiceImpl implements UserService {
   private UserDao userDao=new UserDaoImpl();
   private UserRoleDao userRoleDao=new UserRoleDaoImpl();
     /**
      * µÇÂ½²Ù×÷
      */
	@Override
	public User login(String userName, String password,Integer roleId) {
		User user=null;
		user=userDao.getUserByNameAndPwd(userName);
		if (user!=null) {
			if(!user.getPassword().equals(password)){
				user=null;
			}else if(!userRoleDao.getUserRoleId(user.getId()).equals(roleId)){
				user=null;
			}
		}
		return user;
	}
	@Override
	public List<User> findAllUser() {
		return userDao.getAllUser();
	}

}
