package com.example.demo.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    System.out.println(encoder.encode("test123")); //user
	    
	    //System.out.println(encoder.encode("admin123")); //admin

	}

}
