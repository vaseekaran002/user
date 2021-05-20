package com.mycompany.user.service;

import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.user.pojo.User;
import com.mycompany.user.repository.UserRepository;
import com.mycompany.user.util.DBUtil;


@Service
public class UserService {
    
	@Autowired
	private UserRepository userRepository;
	
	public User insertUser(User user) {
		 return userRepository.save(user);
	}
	
	public User fetchUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User fetchUserByUsernameAndPassword(String username,String password) {
		return userRepository.findByUsernameAndPassword(username,password);
	}
	
	public void deleteUser(String username) {
		userRepository.deleteAllByUsername(username);
	}
	
	public User resetPassword(User user) {
		String tempUsername = user.getUsername();
		deleteUser(tempUsername);
		return userRepository.save(user);
	}
}
