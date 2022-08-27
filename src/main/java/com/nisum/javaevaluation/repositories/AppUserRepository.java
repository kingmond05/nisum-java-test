package com.nisum.javaevaluation.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nisum.javaevaluation.models.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
	@Query(value = "select id from users where email = ?1", nativeQuery = true)
	public String getUserByEmail(String email);
}
