package com.nisum.javaevaluation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.javaevaluation.models.AppUser;
import com.nisum.javaevaluation.repositories.AppUserRepository;

@Service
public class AppUserService {
	
	@Autowired
	private AppUserRepository userRepository;
	
	public void saveUser(AppUser user) {
		userRepository.save(user);
	}
	
	public List<AppUser> listAll(){
		return userRepository.findAll();
	}
}	
