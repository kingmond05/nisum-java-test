package com.nisum.javaevaluation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class InternalErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InternalErrorException(String exception) {
        super(exception);
    }
}
