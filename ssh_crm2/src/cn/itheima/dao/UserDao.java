package cn.itheima.dao;

import cn.itheima.domain.User;

public interface UserDao {
	
	User getByUserCode(String usercode);
	void save(User u);
}
