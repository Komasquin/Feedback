package com.example.UserFeedback.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.UserFeedback.exception.InvalidInputException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = InvalidInputException.class)
    public ResponseEntity<Object> exception(InvalidInputException exception) {
       return new ResponseEntity<>("Invalid Input, please try again!", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
