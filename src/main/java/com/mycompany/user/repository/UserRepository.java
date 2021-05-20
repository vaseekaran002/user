package com.mycompany.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.user.pojo.User;


@Repository
public interface UserRepository extends CrudRepository<User,String> {

	public User findByUsername(String username);
	public User findByUsernameAndPassword(String username,String password);
	public void deleteAllByUsername(String username);
}
