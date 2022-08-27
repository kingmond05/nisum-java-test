package com.nisum.javaevaluation.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nisum.javaevaluation.views.GenericErrorViewModel;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        GenericErrorViewModel error = new GenericErrorViewModel();
        error.mensaje = details.stream()
                .collect(Collectors.joining(","));
        return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(InternalErrorException.class)
    public final ResponseEntity<Object> handleInternalErrorException(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        GenericErrorViewModel error = new GenericErrorViewModel();
        error.mensaje = details.stream()
                .collect(Collectors.joining(","));
        return new ResponseEntity<Object>(error, HttpStatus.BAD_GATEWAY);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<Object> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        GenericErrorViewModel error = new GenericErrorViewModel();
        error.mensaje = errors.toString();
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }

}