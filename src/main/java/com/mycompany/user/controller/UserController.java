package com.mycompany.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.user.pojo.User;
import com.mycompany.user.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService ;
   
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:4200")
	public User insertUser(@RequestBody User user) throws Exception {
		 String tempUsername = user.getUsername();
		 if(tempUsername != null && !"".equals(tempUsername)) {
			 User tempUser = userService.fetchUserByUsername(tempUsername);
			 if(tempUser != null) {
				 throw new Exception("Username "+tempUsername+"already exists");
			 }
		 }
		 User tempUser = null;
		 tempUser =  userService.insertUser(user);
		 return tempUser;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		User tempUser = null;
		String tempUsername = user.getUsername();
		String tempPassword = user.getPassword();
		if(tempUsername != null && tempPassword != null) {
			tempUser = userService.fetchUserByUsernameAndPassword(tempUsername, tempPassword);
		}
		if(tempUser == null) {
			throw new Exception("wrong credentials");
		}
		else {
			System.out.println("Login success");
		}
		return tempUser;
	}
	
	@PostMapping("/reset-password")
	@CrossOrigin(origins = "http://localhost:4200")
	public User resetPassword(@RequestBody User user) throws Exception {
		User tempUser = null;
		String tempUsername = user.getUsername();
		if(tempUsername != null) {
			tempUser = userService.resetPassword(user);
		}
		if(tempUser ==null) {
			throw new Exception("username not found");
		}
		return tempUser;
	}
}
