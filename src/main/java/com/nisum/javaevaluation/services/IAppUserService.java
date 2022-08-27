package com.nisum.javaevaluation.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;

import com.nisum.javaevaluation.models.AppUser;
import com.nisum.javaevaluation.views.AppUserViewModelRequest;
import com.nisum.javaevaluation.views.AppUserViewModelResponse;

public interface IAppUserService {
	public AppUserViewModelResponse saveUser(AppUserViewModelRequest user) throws 
		NoSuchAlgorithmException, 
		MethodArgumentNotValidException;
	public List<AppUser> listAll();	
	public String getUserByEmail(String email);
}
