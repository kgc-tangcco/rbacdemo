package cn.kgc.tangcco.service;

import java.util.List;

import cn.kgc.tangcco.entity.Menu;

public interface MenuService {
	 List<Menu> findOneMenu(Integer userId);
	 List<Menu> findTwoMenu(Integer userId,Integer parentId);
}
