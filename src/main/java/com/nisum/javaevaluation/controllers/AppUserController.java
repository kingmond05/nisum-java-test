package com.nisum.javaevaluation.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.javaevaluation.models.AppUser;
import com.nisum.javaevaluation.services.AppUserService;
import com.nisum.javaevaluation.views.AppUserViewModelRequest;
import com.nisum.javaevaluation.views.AppUserViewModelResponse;
import com.nisum.javaevaluation.views.GenericErrorViewModel;

@RestController
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
@RequestMapping("/api/v1")
public class AppUserController {

	@Autowired
	private AppUserService userService;
	private UserValidationConfig validationConfig;

	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getAllUser() {
		List<AppUser> users = userService.listAll();
		if(users.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(users);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	@PostMapping("/user")
	public ResponseEntity<?> createUser(@Valid @RequestBody AppUserViewModelRequest model) {
		try {
			
			if(userService.getUserByEmail(model.email) != null) {
				GenericErrorViewModel resp = new GenericErrorViewModel();
				validationConfig = new UserValidationConfig();
				resp.mensaje = (validationConfig.existingemailerrortext != null ?
						validationConfig.existingemailerrortext : 
							"El correo ya fue registrado");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(resp);
			}
			AppUserViewModelResponse response = userService.saveUser(model);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (NoSuchAlgorithmException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
