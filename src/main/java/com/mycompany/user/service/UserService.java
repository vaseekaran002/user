package com.mycompany.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.user.pojo.User;
import com.mycompany.user.repository.UserRepository;

@Service
public class UserService {
    
	@Autowired
	private UserRepository userRepository;
	public void createUser(User user) {
		
		userRepository.createUser(user);
	}		
	
	public void deleteUser(User user) {
		userRepository.deleteUser(user);
	}
	
	public void updateUser(User user) {
		userRepository.updateUser(user);
	}
	
	public void displayUser() {
		userRepository.display();
	}
}
