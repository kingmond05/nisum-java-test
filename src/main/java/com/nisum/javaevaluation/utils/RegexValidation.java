package com.nisum.javaevaluation.utils;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class RegexValidation {

	public boolean applyRegexValidation(String regx, String field) {
	    return Pattern.compile(regx.replaceAll("//", "\\")).matcher(field).matches();
	}
}
