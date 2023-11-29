package com.Course.Exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobelExceptionHandler {
   
	@ExceptionHandler(CourseNotFound.class)
	public ResponseEntity<MyErrorDetails> handler(Exception ex , WebRequest wr){
		 MyErrorDetails er = new MyErrorDetails();
		 er.setLocalDateTime(LocalDateTime.now());
		 er.setDescription(wr.getDescription(false));
		 er.setMesseage(ex.getMessage());
		return new ResponseEntity<MyErrorDetails>(er, HttpStatus.BAD_REQUEST);
		
	}
}
