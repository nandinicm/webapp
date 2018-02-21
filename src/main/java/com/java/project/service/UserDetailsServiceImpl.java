package com.java.project.service;

import static java.util.Collections.emptyList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.java.project.dao.AppUser;
import com.java.project.repository.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private AppUserRepository applicationUserRepository;

	public UserDetailsServiceImpl( AppUserRepository applicationUserRepository )
	{
		this.applicationUserRepository = applicationUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
	{
		AppUser applicationUser = applicationUserRepository.findByUsername(username);
		if( applicationUser == null )
		{
			throw new UsernameNotFoundException(username);
		}
		return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
	}
}