package com.persadoproject.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class ResourceNotFoundAdvice extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		List<String> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}

		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, new Date(), request.getDescription(false), errors);
		return handleExceptionInternal(ex, errorMessage, headers, errorMessage.getStatusCode(), request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getMessage());
		ErrorMessage message = new ErrorMessage(
				HttpStatus.BAD_REQUEST,
				new Date(),
				request.getDescription(false),
				errors

		);
		return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		if(ex.getMessage().contains("Failed to deserialize java.time.LocalDate")){
			errors.add("Invalid input date format. Valid date format example: 1970-12-30 (Year-Month-Day)");
		} else {
			errors.add(ex.getMessage());
		}

		ErrorMessage message = new ErrorMessage(
				HttpStatus.BAD_REQUEST,
				new Date(),
				request.getDescription(false),
				errors

		);
		return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ResourceNotFoundException.class, GeneralCustomException.class,  Exception.class})
	public ResponseEntity<ErrorMessage> resourceNotFoundException(Exception e, WebRequest req) {
		HttpStatus httpStatus;

		if(e instanceof ResourceNotFoundException){
			httpStatus = HttpStatus.NOT_FOUND;
		} else if(e instanceof GeneralCustomException){
			httpStatus = HttpStatus.BAD_REQUEST;
		} else {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		List<String> errors = new ArrayList<>();
		if(e.getMessage().contains("nested exception is org.hibernate.exception.ConstraintViolationException") && e.getMessage().contains("[FK_")){
			errors.add("There is a reference to a non existing entity.");
		} else {
			errors.add(e.getMessage());
		}

		ErrorMessage message = new ErrorMessage(
				httpStatus,
				new Date(),
				req.getDescription(false),
				errors

		);
		return new ResponseEntity<ErrorMessage>(message, httpStatus);
	}
}
