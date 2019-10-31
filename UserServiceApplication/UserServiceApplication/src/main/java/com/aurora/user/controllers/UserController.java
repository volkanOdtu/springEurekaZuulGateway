package com.aurora.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurora.user.dtos.UserDetailsDTO;
import com.aurora.user.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/saveUpdate")
	public UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO user)
	{
		return userService.saveUpdate(user);
	}
	@GetMapping(value = "/getById/{id}")
	public UserDetailsDTO getUserById(@PathVariable Long id) {
		return userService.getById(id);
	}
	@GetMapping(value = "/getByName/{name}")
	public List<UserDetailsDTO>  getUserByName(@PathVariable String name) {
		return userService.getByName(name);
	}
}
