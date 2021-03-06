package cn.itheima.service.imp;

import cn.itheima.dao.UserDao;
import cn.itheima.domain.User;
import cn.itheima.service.UserService;

public class UserServiceImp implements UserService{

	private UserDao ud;
	
	@Override
	public User getUserByCodePassword(User u) {
			//1 根据登陆名称查询登陆用户
			User existU = ud.getByUserCode(u.getUser_code());
			//2 判断用户是否存在.不存在=>抛出异常,提示用户名不存在
			if(existU==null){
				throw new RuntimeException("用户名不存在!");
			}
			//3 判断用户密码是否正确=>不正确=>抛出异常,提示密码错误
			if(!existU.getUser_password().equals(u.getUser_password())){
				throw new RuntimeException("密码错误!");
			}
			//4 返回查询到的用户对象
		
		return existU;
	}

	@Override
	public void saveUser(User u) {
		ud.save(u);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

}
