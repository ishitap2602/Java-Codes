package com.test.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
public ResponseEntity<ErrorMessage> studentNotFoundException(StudentNotFoundException sne,WebRequest request)
{
	ErrorMessage message=new ErrorMessage();
	
	message.setTimeStamp(new Date());
	message.setMessage(sne.getMessage());
	message.setUrl(request.getDescription(false));
	
	int code=HttpStatus.NOT_FOUND.value();
	
	message.setStatusCode(code);
	
	return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
	
	
}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> unknownException(Exception e,WebRequest request)
	{
		ErrorMessage message=new ErrorMessage();
		
		message.setTimeStamp(new Date());
		message.setMessage(e.getMessage());
		message.setUrl(request.getDescription(false));
		
		int code=HttpStatus.BAD_REQUEST.value();
		
		message.setStatusCode(code);
		
		return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
	}
}
