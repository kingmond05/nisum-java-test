package com.nisum.javaevaluation.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nisum.javaevaluation.models.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
	public String getUserByEmail(String email);
}
