package com.nisum.javaevaluation.controllers;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "inputvalidation")
@Getter
@Setter
public final class UserValidationConfig {
	 public String existingemailerrortext;
	 public String passwordregex;
	 public String passwordregexerrortext;
	 public String emailregexerrortext;
	 public String requiredpasswordtext;
	 public String requiredbnametext;
	 public String requiredemailtext;
}
 