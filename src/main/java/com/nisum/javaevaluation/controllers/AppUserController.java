package com.nisum.javaevaluation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.javaevaluation.exceptions.CustomExceptionHandler;
import com.nisum.javaevaluation.exceptions.InternalErrorException;
import com.nisum.javaevaluation.models.AppUser;
import com.nisum.javaevaluation.services.AppUserService;
import com.nisum.javaevaluation.views.AppUserViewModelRequest;

@RestController
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class AppUserController {

	@Autowired
	private AppUserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getAllUser() {
		List<AppUser> users = userService.listAll();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	@PostMapping("/user")
	public ResponseEntity<?> createUser(@Valid @RequestBody AppUserViewModelRequest model) {
		try {
			userService.saveUser(model);
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		}
		catch (Exception e) {
			throw new InternalErrorException(e.getMessage());
		}
	}
}
