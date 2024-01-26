package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.User;
import com.security.service.UserService;

@RestController
@RequestMapping("/security")
public class SecurityController {
	@Autowired
	private UserService userService;
	
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/get")
	//all users
	public List<User>  getAllUsers(){
		return  this.userService.getAllUsers();
	}
	@GetMapping("/{username}")
	public User getUsers(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	@PostMapping("/add")
	public User add(@RequestBody User user) {
		return this.userService.addUser(user);
	}
}
