package cn.kgc.tangcco.service.impl;

import java.util.List;

import cn.kgc.tangcco.dao.MenuDao;
import cn.kgc.tangcco.dao.impl.MenuDaoImpl;
import cn.kgc.tangcco.entity.Menu;
import cn.kgc.tangcco.service.MenuService;

public class MenuServiceImpl implements MenuService {
    private MenuDao menuDao=new MenuDaoImpl();
	@Override
	public List<Menu> findOneMenu(Integer userId) {
		return menuDao.getOneMenu(userId);
	}
	@Override
	public List<Menu> findTwoMenu(Integer userId,Integer parentId) {
		return menuDao.getTwoMenu(userId,parentId);
	}

}
