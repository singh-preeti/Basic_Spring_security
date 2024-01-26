package com.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.model.User;

@Service
public class UserService {
	
	List<User> list = new ArrayList<>();
	
	public UserService() {
		list.add(new User("Preeti", "Password", "singhpreety217@gmail.com"));
		list.add(new User("Sumit", "Password", "sumit217@gmail.com"));
	}
	//get list of all the user
	public List<User> getAllUsers(){
		return this.list;
	}
    // get user by username
	public User getUser(String username)
	{
		return this.list
				   .stream()
				   .filter((user) -> user.getUsername().equals(username))
				   .findAny()
				   .orElse(null);
	}
	//add the users
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
}
