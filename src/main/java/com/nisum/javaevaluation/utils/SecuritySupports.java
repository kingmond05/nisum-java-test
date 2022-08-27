package com.nisum.javaevaluation.utils;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class SecuritySupports {

	final String pepper = "GfUAUJMv7hjXpgU8vZKUtt8a";
	final int iterations = 200000;
	final int hashWidth = 256;
	
	public String hashUserPassword(String pass) {
		Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder(pepper, iterations, hashWidth);
		pbkdf2PasswordEncoder.setEncodeHashAsBase64(true);
		String encodedPassword = pbkdf2PasswordEncoder.encode(pass);
		return encodedPassword;
	}
}
