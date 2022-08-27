package com.nisum.javaevaluation.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class RegexValidation {

	public boolean applyRegexValidation(String regx, String field) {
		Pattern pattern = Pattern.compile(regx);
	    Matcher matcher = pattern.matcher(field);
	    int matches = 0;
	    while (matcher.find()) {
	        matches++;
	    }
	    return matches != 0;
	}
}
