package cn.itheima.web;

import cn.itheima.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	
	public UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() {
		
		System.out.println(userService);
		
		return "success";
	}
	
	
	
}
