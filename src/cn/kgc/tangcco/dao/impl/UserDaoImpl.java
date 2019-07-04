package cn.kgc.tangcco.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.kgc.tangcco.dao.UserDao;
import cn.kgc.tangcco.entity.User;
import cn.kgc.tangcco.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {
	//QueryRunner 进行查询的操作
	private QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
   /**
    * 根据用户名查询用户
    */
	@Override
	public User getUserByNameAndPwd(String userName) {
		User user=null;
		String sql="SELECT 	id, username, PASSWORD, nickname, telephone, email, create_time, update_time, account_status, STATUS FROM rbacdb.jrbac_login_user WHERE username=?; ";
		Object[] params={userName};
		try {
			user=runner.query(sql, new BeanHandler<User>(User.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public List<User> getAllUser() {
		List<User> userList=new ArrayList<>();
		String sql="SELECT id,username,PASSWORD,nickname,telephone,email,create_time,account_status,STATUS FROM jrbac_login_user";
		try {
			userList=runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

}
