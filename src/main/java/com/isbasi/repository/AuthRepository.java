package com.isbasi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isbasi.model.User;

public interface AuthRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmailAndPassword(String email, String password);

}
