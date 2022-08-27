package com.nisum.javaevaluation.controllers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("inputvalidation")
public class UserValidationConfig {
	 private String existingemailerrortext;
	 private String passwordregex;
	 private String passwordregexerrortext;
	 private String genericerrormessage;
	 
	public String getGenericerrormessage() {
		return genericerrormessage;
	}
	public void setGenericerrormessage(String genericerrormessage) {
		this.genericerrormessage = genericerrormessage;
	}
	public String getExistingemailerrortext() {
		return existingemailerrortext;
	}
	public void setExistingemailerrortext(String existingemailerrortext) {
		this.existingemailerrortext = existingemailerrortext;
	}
	public String getPasswordregex() {
		return passwordregex;
	}
	public void setPasswordregex(String passwordregex) {
		this.passwordregex = passwordregex;
	}
	public String getPasswordregexerrortext() {
		return passwordregexerrortext;
	}
	public void setPasswordregexerrortext(String passwordregexerrortext) {
		this.passwordregexerrortext = passwordregexerrortext;
	}
}
 