package com.example.demo.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.CustomUserDetailsService;
import com.example.demo.util.JwtUtil;
import com.example.demo.dto.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final CustomUserDetailsService userDetailsService;
	private final JwtUtil jwtUtil;
	
	public AuthController(AuthenticationManager authenticationManager,CustomUserDetailsService userDetailsService,JwtUtil jwtUtil)
	{
		this.authenticationManager=authenticationManager;
		this.userDetailsService=userDetailsService;
		this.jwtUtil=jwtUtil;
	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest request)
	{
		System.err.println("Login API Hit");
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		
		System.err.println("USERNAME:"+userDetails.getUsername());
		String token = jwtUtil.generateToken(userDetails.getUsername());
		
		System.err.println("Token Genrated :"+token);
		
		
		return ResponseEntity.ok(new AuthResponse(token));
		
		
		
	}

}
