package cn.kgc.tangcco.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.kgc.tangcco.dao.MenuDao;
import cn.kgc.tangcco.entity.Menu;
import cn.kgc.tangcco.utils.JDBCUtils;

public class MenuDaoImpl implements MenuDao {
   //QueryRunner是用来进行查询的
	private QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public List<Menu> getOneMenu(Integer userId) {
		List<Menu> menuIdList=new ArrayList<>();
		String sql="SELECT DISTINCT menu.id,menu.NAME,menu.parent_id,menu.url,menu.icon,menu.order FROM jrbac_login_user loginUser INNER JOIN jrbac_user_role userRole ON loginUser.id=userRole.user_id INNER JOIN jrbac_role_menu roleMenu ON userRole.role_id=roleMenu.role_id INNER JOIN jrbac_menu  menu ON roleMenu.menu_id=menu.id WHERE loginUser.id=? AND menu.parent_id=''";
		Object[] params={userId};
		try {
			menuIdList=runner.query(sql, new BeanListHandler<Menu>(Menu.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuIdList;
	}
	/**
	 * 根据父级id查询子id
	 */
	@Override
	public List<Menu> getTwoMenu(Integer userId,Integer parentId) {
		List<Menu> menuList=new ArrayList<>();
		String sql="SELECT DISTINCT menu.id,menu.NAME,menu.parent_id,menu.url,menu.icon,menu.order FROM jrbac_login_user loginUser INNER JOIN jrbac_user_role userRole ON loginUser.id=userRole.user_id INNER JOIN jrbac_role_menu roleMenu ON userRole.role_id=roleMenu.role_id INNER JOIN jrbac_menu  menu ON roleMenu.menu_id=menu.id WHERE loginUser.id=? AND menu.parent_id=?";
		Object[] params={userId,parentId};
		try {
			menuList=runner.query(sql, new BeanListHandler<Menu>(Menu.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;
	}

}
