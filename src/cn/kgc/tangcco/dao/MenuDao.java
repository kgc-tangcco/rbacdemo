package cn.kgc.tangcco.dao;

import java.util.List;

import cn.kgc.tangcco.entity.Menu;

public interface MenuDao {
   List<Menu> getOneMenu(Integer userId);
   List<Menu> getTwoMenu(Integer userId,Integer parentId);
}
