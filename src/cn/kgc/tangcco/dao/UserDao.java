package cn.kgc.tangcco.dao;

import java.util.List;

import cn.kgc.tangcco.entity.User;

public interface UserDao {
	//�����û�����ѯ�û�
    User getUserByNameAndPwd(String userName);
    //��ѯ���е��û�
    List<User> getAllUser();
}
