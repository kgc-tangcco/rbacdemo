package cn.kgc.tangcco.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.kgc.tangcco.dao.MenuDao;
import cn.kgc.tangcco.dao.UserRoleDao;
import cn.kgc.tangcco.dao.impl.MenuDaoImpl;
import cn.kgc.tangcco.dao.impl.UserRoleDaoImpl;
import cn.kgc.tangcco.entity.Menu;

public class TestDemo {

	@Test
	public void test() {
		/*UserRoleDao userRoleDao=new UserRoleDaoImpl();
		Integer roleId=userRoleDao.getUserRoleId(1);
		System.out.println(roleId);*/
		MenuDao menuDao=new MenuDaoImpl();
		List<Menu> list=menuDao.getOneMenu(1);
		for (Menu menu : list) {
			System.out.println(menu.getId());
		}
	}

}
