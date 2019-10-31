package com.aurora.resource.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurora.resource.dtos.UserDetailsDTO;
import com.aurora.resource.feignService.UserServiceFeign;

@RestController
@RequestMapping("/api")
public class UserResourceController {

	@Autowired
	private UserServiceFeign userServiceFeign;
	
	@PostMapping("/saveUpdate")
	public UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO userDetailsDTO)
	{
		return userServiceFeign.saveUpdate(userDetailsDTO);
	}
	
	@GetMapping("/getById/{id}")
	public UserDetailsDTO getUserById(@PathVariable Long id)
	{
		return userServiceFeign.getUserById(id);
	}
	@GetMapping("/getByName/{name}")
	public List<UserDetailsDTO> getUserByName(@PathVariable String name)
	{
		return userServiceFeign.getUserByName(name);
	}
	
}
