package cn.kgc.tangcco.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.kgc.tangcco.dao.UserRoleDao;
import cn.kgc.tangcco.entity.UserRole;
import cn.kgc.tangcco.utils.JDBCUtils;

public class UserRoleDaoImpl implements UserRoleDao {
   
	//QueryRunner进行查询操作
	private QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public Integer getUserRoleId(Integer userId) {
		Integer roleId=null;
		String sql="SELECT 	role_id FROM rbacdb.jrbac_user_role WHERE user_id=?";
		Object[] params={userId};
		try {
			roleId=Integer.parseInt(runner.query(sql,new ScalarHandler<>(1),params));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roleId;
	}
	@Override
	public Integer addUserRole(UserRole userRole) {
		Integer result=0;
		String sql="INSERT INTO rbacdb.jrbac_user_role (user_id, role_id)VALUES(?, ?);";
		Object[] params={userRole.getUserId(),userRole.getRoleId()};
		try {
			result=runner.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 根据用户编号查询没有的角色id
	 */
	@Override
	public List<UserRole> getUserRoleList(Integer userId) {
		List<UserRole> userRoleList=new ArrayList<>();
		String sql="SELECT jrbac_role.id  FROM jrbac_role   WHERE jrbac_role.id NOT IN(SELECT userRole.role_id FROM jrbac_login_user loginUser INNER JOIN jrbac_user_role userRole ON loginUser.id=userRole.user_id WHERE loginUser.id=?);";
		Object[] params={userId};
		try {
			userRoleList=runner.query(sql, new BeanListHandler<UserRole>(UserRole.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userRoleList;
	}

}
