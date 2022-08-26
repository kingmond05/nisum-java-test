package com.nisum.javaevaluation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.javaevaluation.models.AppUser;
import com.nisum.javaevaluation.services.AppUserService;

@RestController
@EnableAutoConfiguration(exclude = { 
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class 
    })
@RequestMapping("/api/v1")
public class AppUserController {

	@Autowired
	private AppUserService userService;
	
	@GetMapping("/users")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AppUser>> getAllUser() {
		List<AppUser> users = userService.listAll();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	@PostMapping("/user")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<List<AppUser>> createUser(AppUser model) {
		return null;
	}
}
