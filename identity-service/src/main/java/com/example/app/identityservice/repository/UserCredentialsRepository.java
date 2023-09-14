package com.example.app.identityservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.identityservice.entity.UserCredentials;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Integer> {
	
	Optional<UserCredentials> findByName(String name);

}
