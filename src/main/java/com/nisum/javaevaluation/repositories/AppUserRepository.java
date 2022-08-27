package com.nisum.javaevaluation.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nisum.javaevaluation.models.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	String getUserByEmail(String email);
}	
