//package com.example.demo.controller;
//
//import java.util.HashMap;
//import java.util.Locale;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import com.example.demo.constants.StatusCode;
//import com.example.demo.exception.BookNotFoundException;
//import com.example.demo.exception.DuplicateBookException;
//import com.example.demo.exception.InvalidDataException;
//import com.example.demo.model.response.ValidatorResponse;
//
//
//
//@RestControllerAdvice
//public class ExceptionHandlerGarbage extends ResponseEntityExceptionHandler {
//	
//	@Autowired
//	private MessageSource messageSource;
//
//	
//	
//	@Override
//	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//		 Map<String, String> errors = new HashMap<>();
//		ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.BAD_REQUEST, StatusCode.BAD_REQUEST_MESSAGE, null, null);
//	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//	}
	
//	@Override
//	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//	    ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.BAD_REQUEST, "잘못된 제이슨 응답입니다.", null, null);
//	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//	}

//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//	    Map<String, String> errors = new HashMap<>();
//	    ex.getBindingResult().getAllErrors().forEach((error) -> {
//	        String fieldName = ((FieldError) error).getField();
//	        String errorMessage = error.getDefaultMessage();
//	        errors.put(fieldName, errorMessage);
//	    });
//	    ValidatorResponse<?> response = new ValidatorResponse<>(status.value(), "Validation failed", null, errors);
//	    return new ResponseEntity<>(response, status);
//	}
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//	    Map<String, String> errors = new HashMap<>();
//	    ex.getBindingResult().getAllErrors().forEach((error) -> {
//	        String fieldName = ((FieldError) error).getField();
//	        String errorMessage = error.getDefaultMessage();
//	        errors.put(fieldName, errorMessage);
//	    });
//	    ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.BAD_REQUEST, StatusCode.BAD_REQUEST_MESSAGE, null, errors);
//
//	    return new ResponseEntity<>(response, status);
//	}
//	
	


//	@ExceptionHandler(BookNotFoundException.class)
//	public final ResponseEntity<ValidatorResponse<?>> handleBookNotFoundException(BookNotFoundException ex, WebRequest request) {
//	    ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.NOT_FOUND, ex.getMessage() != null ? ex.getMessage() : StatusCode.NOT_FOUND_MESSAGE, null, null);
//	    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//	}
	
	// 예외 핸들러 내에서 메세지 소스를 사용해서 가져오는 코드
//	@ExceptionHandler(BookNotFoundException.class)
//	public final ResponseEntity<ValidatorResponse<?>> handleBookNotFoundException(BookNotFoundException ex, WebRequest request, Locale locale) {
//	    String localizedMessage = messageSource.getMessage("book.error.add", null, locale);
//	    ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.NOT_FOUND, localizedMessage, null, null);
//	    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//	}
//
//
//	@ExceptionHandler(InvalidDataException.class)
//	public final ResponseEntity<ValidatorResponse<?>> handleInvalidDataException(InvalidDataException ex, WebRequest request) {
//	    ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.BAD_REQUEST, ex.getMessage() != null ? ex.getMessage() : StatusCode.BAD_REQUEST_MESSAGE, null, null);
//	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(DuplicateBookException.class)
//	public final ResponseEntity<ValidatorResponse<?>> handleDuplicateBookException(DuplicateBookException ex, WebRequest request) {
//	    ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.UNPROCESSABLE_ENTITY, ex.getMessage() != null ? ex.getMessage() : StatusCode.UNPROCESSABLE_ENTITY_MESSAGE, null, null);
//	    return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
//	}
//	
//
//
//	
//    
//}
