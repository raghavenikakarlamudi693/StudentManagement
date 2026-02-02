package com.example.demo.service;

import com.example.demo.repository.UserRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	
	@Autowired
	private final UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) 
	{
		this.userRepository=userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		
		
		User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found: " + username));

			
		return org.springframework.security.core.userdetails.User
		        .withUsername(user.getUsername())
		        .password(user.getPassword())
		        .roles(user.getRole().replace("ROLE_", ""))
		        .build();

		}
    

}
