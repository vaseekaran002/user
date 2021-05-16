package com.mycompany.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.user.pojo.User;
import com.mycompany.user.service.UserService;

@Component
public class UserController {
	
	
	@Autowired
	private UserService userService ;
//	UserService userService = new UserService();
	public void createUser(int id,String name,String phone) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPhone(phone);
		userService.createUser(user);
	}
	
	public void deleteUser(int id) {
		User user = new User();
		user.setId(id);
		userService.deleteUser(user);
	}
	
	public void updateUser(int id,String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		userService.updateUser(user);
	}
	
	public void displayUser() {
		userService.displayUser();
	}
}
