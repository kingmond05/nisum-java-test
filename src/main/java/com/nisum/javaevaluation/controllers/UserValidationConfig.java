package com.nisum.javaevaluation.controllers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("inputvalidation")
public class UserValidationConfig {
	 private String existingemailerrortext;
	 private String passwordregex;
	 private String passwordregexerrortext;
	 private String emailregexerrortext;
	 private String requiredpasswordtext;
	 private String requiredbnametext;
	 private String requiredemailtext;
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
	public String getEmailregexerrortext() {
		return emailregexerrortext;
	}
	public void setEmailregexerrortext(String emailregexerrortext) {
		this.emailregexerrortext = emailregexerrortext;
	}
	public String getRequiredpasswordtext() {
		return requiredpasswordtext;
	}
	public void setRequiredpasswordtext(String requiredpasswordtext) {
		this.requiredpasswordtext = requiredpasswordtext;
	}
	public String getRequiredbnametext() {
		return requiredbnametext;
	}
	public void setRequiredbnametext(String requiredbnametext) {
		this.requiredbnametext = requiredbnametext;
	}
	public String getRequiredemailtext() {
		return requiredemailtext;
	}
	public void setRequiredemailtext(String requiredemailtext) {
		this.requiredemailtext = requiredemailtext;
	}
	 
	 
}
 