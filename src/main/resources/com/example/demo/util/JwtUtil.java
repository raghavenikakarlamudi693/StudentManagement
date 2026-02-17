package com.example.demo.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	private String secret = "mySecretKey";
	
	public String generateToken(String username)
	{
		 return Jwts.builder()
				 .setSubject(username)
				 .setIssuedAt(new Date())
				 .setExpiration(new Date(System.currentTimeMillis() +1000*60*60))//1 hour
				 .signWith(SignatureAlgorithm.HS256, secret)
				 .compact();
	}
	
	public String extractUsername(String token)
	{
		return getClaims(token).getSubject();
	}
	
	public boolean validateToken(String token,String username)
	{
		String extractedUsername = extractUsername(token);
		return (extractedUsername.equals(username) && ! isTokenExpired(token));
	}
	
	private boolean isTokenExpired(String token)
	{
		return getClaims(token).getExpiration().before(new Date());
	}
	
	private Claims getClaims(String token)
	{
		return Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();
	}

}
