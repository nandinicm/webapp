package com.java.project.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.project.dao.AppUser;
import com.java.project.repository.AppUserRepository;

@RestController
@RequestMapping( "/users" )
public class UserController {

	private AppUserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserController( AppUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder )
	{
		this.userRepository = applicationUserRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping( "/sign-up" )
	public void signUp( @RequestBody AppUser user )
	{
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
}