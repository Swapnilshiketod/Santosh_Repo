package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.ErrorDetails;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = LoanIdNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleLoanAccountNotFoundException(LoanIdNotFoundException ex) {

		ErrorDetails exceptionResponse = new ErrorDetails(new Date(), "LoanId not found", "404");
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = BadRequestException.class)
	public final ResponseEntity<ErrorDetails> forBadRequest(BadRequestException ex) {

		ErrorDetails exceptionResponse = new ErrorDetails(new Date(), "Invalid LoanId", "400");
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);

	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>(new ErrorDetails(new Date(), "405", ex.getMessage()),
				HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex) {

		ErrorDetails exceptionResponse = new ErrorDetails(new Date(), "Please contact admin", "500");
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	

}
