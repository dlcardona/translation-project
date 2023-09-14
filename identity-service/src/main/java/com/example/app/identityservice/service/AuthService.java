package com.example.app.identityservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.app.identityservice.entity.UserCredentials;
import com.example.app.identityservice.repository.UserCredentialsRepository;

@Service
public class AuthService {

	@Autowired
	private UserCredentialsRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private JwtService jwtService;

	public UserCredentials saveUser(UserCredentials credentials) {
		credentials.setPassword(passwordEncoder.encode(credentials.getPassword()));
		return repository.save(credentials);
	}

	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}

	public void validateToken(String token) {
		jwtService.validateToken(token);
	}

}
