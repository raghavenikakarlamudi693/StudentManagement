
package com.example.demo.util;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
	public class JwtUtil {

	    private String secret = "mySecretKeymySecretKeymySecretKey3";

	    public String generateToken(String username) {
	        return Jwts.builder()
	                .setSubject(username)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
	                .signWith(Keys.hmacShaKeyFor(secret.getBytes()),SignatureAlgorithm.HS256)
	                .compact();
	    }

	    public String extractUsername(String token) {
	        return getClaims(token).getSubject();
	    }

	    public boolean validateToken(String token, String username) {
	        String extractedUsername = extractUsername(token);
	        return extractedUsername.equals(username) && !isTokenExpired(token);
	    }

	    private boolean isTokenExpired(String token) {
	        return getClaims(token).getExpiration().before(new Date());
	    }

	    private Claims getClaims(String token) {
	        return Jwts.parserBuilder()
	                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
	                .build()
	                .parseClaimsJws(token)
	                .getBody();
	    }
	}


