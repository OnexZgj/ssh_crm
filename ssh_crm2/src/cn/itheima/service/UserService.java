package cn.itheima.service;

import cn.itheima.domain.User;



public interface UserService {

	User getUserByCodePassword(User u);

	void saveUser(User u);
	
}
