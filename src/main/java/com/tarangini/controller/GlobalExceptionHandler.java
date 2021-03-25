package com.tarangini.controller;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tarangini.exception.DuplicateSubscriberException;
import com.tarangini.exception.DuplicateSubscriptionException;
import com.tarangini.exception.InvalidSubscriberDetailsException;
import com.tarangini.exception.InvalidSubscriptionDetailsException;
import com.tarangini.exception.SubscriberNotFoundException;
import com.tarangini.exception.SubscriptionNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = {InvalidSubscriberDetailsException.class,InvalidSubscriptionDetailsException.class})
	public ResponseEntity<Object> handleInvalidExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {DuplicateSubscriberException.class,DuplicateSubscriptionException.class})
	public ResponseEntity<Object> handleDuplicateExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.CONFLICT);
	}
		
	@ExceptionHandler(value = {SubscriberNotFoundException.class,SubscriptionNotFoundException.class})
	public ResponseEntity<Object> handleNotFoundExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleAnyException(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	static String messageFrom(BindingResult result) {		
		return result.getAllErrors().stream()
				.map(err -> err.getObjectName() + "-"+err.getDefaultMessage())
				.collect(Collectors.toList()).toString();
	}
}
