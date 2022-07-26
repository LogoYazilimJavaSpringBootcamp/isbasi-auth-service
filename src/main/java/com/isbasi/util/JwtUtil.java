package com.isbasi.util;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.isbasi.model.User;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private static final long EXPIRATION_TIME = 300_000;

	private static final String SECRET_KEY = "logo_yazilim-patika-top-secret-key-logo_yazilim-patika-top-secret-key";

	private Key key;

	@PostConstruct
	public void init() {
		this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}

	public String generateToken(User foundUser) {

		Map<String, Object> claims = new HashMap<>();

		claims.put("email", foundUser.getEmail());
		claims.put("firmType", foundUser.getFirmType().toString());
		claims.put("id", foundUser.getId());
		claims.put("student1", "Çağla");
		claims.put("student2", "Onur");

		long now = System.currentTimeMillis();

		//// @formatter:off
		return Jwts.builder()
				.setClaims(claims)
				.setIssuer("isbasi-auth")
				.setSubject(foundUser.getEmail())
				.setIssuedAt(new Date())
				.setExpiration(new Date(now + EXPIRATION_TIME))
				.signWith(key, SignatureAlgorithm.HS512)
				.compact();
		// @formatter:on

	}

}
