package cn.kgc.tangcco.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.kgc.tangcco.dao.RoleDao;
import cn.kgc.tangcco.entity.Role;
import cn.kgc.tangcco.entity.UserRole;
import cn.kgc.tangcco.utils.JDBCUtils;

public class RoleDaoImpl implements RoleDao {
	//QueryRunner是用来进行查询的
		private QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public List<Role> getRoleListByUserId(Integer userId) {
		List<Role>  roleList=new ArrayList<>();
		String sql="SELECT jrbac_role.id,jrbac_role.name  FROM jrbac_role   WHERE jrbac_role.id NOT IN(SELECT userRole.role_id FROM jrbac_login_user loginUser INNER JOIN jrbac_user_role userRole ON loginUser.id=userRole.user_id WHERE loginUser.id=?);";
		Object[] params={userId};
		try {
			roleList=runner.query(sql, new BeanListHandler<Role>(Role.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roleList;
	}

}
