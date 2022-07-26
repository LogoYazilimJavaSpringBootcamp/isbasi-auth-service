package com.isbasi.service;

import org.springframework.stereotype.Service;

import com.isbasi.dto.AuthRequest;
import com.isbasi.dto.AuthResponse;
import com.isbasi.exception.UserNotFoundException;
import com.isbasi.model.User;
import com.isbasi.repository.AuthRepository;
import com.isbasi.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final AuthRepository authRepository;

	private final JwtUtil jwtUtil;

	public AuthResponse getToken(AuthRequest request) {

		User foundUser = authRepository.findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(() -> new UserNotFoundException("user not found"));

		String token = jwtUtil.generateToken(foundUser);

		return new AuthResponse(token);

	}

}
