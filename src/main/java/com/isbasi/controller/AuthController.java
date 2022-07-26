package com.isbasi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isbasi.dto.AuthRequest;
import com.isbasi.dto.AuthResponse;
import com.isbasi.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping(value = "/auth")
	public ResponseEntity<AuthResponse> getToken(@RequestBody AuthRequest request) {

		return new ResponseEntity<>(authService.getToken(request), HttpStatus.OK);

	}

}
