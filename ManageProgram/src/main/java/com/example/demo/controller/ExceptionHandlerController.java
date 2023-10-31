package com.example.demo.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.constants.ExceptionMessageCode;
import com.example.demo.constants.StatusCode;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.DuplicateBookException;
import com.example.demo.exception.InvalidDataException;
import com.example.demo.model.response.ValidatorResponse;

//이넘에 맞게 핸들러 수정 코드
//@RestControllerAdvice
//public class ExceptionHandlerController extends ResponseEntityExceptionHandler{
//
//	@Autowired
//	private MessageSource messageSource;
//	
//	 @Override
//	    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//	        String localizedMessage = messageSource.getMessage(ExceptionMessageCode.INVALID_DATA.getCode(), null, LocaleContextHolder.getLocale());
//	        ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.BAD_REQUEST, localizedMessage, null, null);
//	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//	    }
//	 
//	 @Override
//	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//	        Map<String, String> errors = new HashMap<>();
//	        ex.getBindingResult().getAllErrors().forEach((error) -> {
//	            String fieldName = ((FieldError) error).getField();
//	            String errorCode = error.getDefaultMessage();
//	            String localizedMessage = messageSource.getMessage(errorCode, null, LocaleContextHolder.getLocale());
//	            errors.put(fieldName, localizedMessage);
//	        });
//
//	        ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.UNPROCESSABLE_ENTITY, StatusCode.UNPROCESSABLE_ENTITY_MESSAGE, null, errors);
//	        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
//	    }
//	 
//	 @ExceptionHandler(BookNotFoundException.class)
//	    public final ResponseEntity<ValidatorResponse<?>> handleBookNotFoundException(BookNotFoundException ex, WebRequest request) {
//	        String localizedMessage = getLocalizedMessage(ExceptionMessageCode.BOOK_NOT_FOUND);
//	        ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.NOT_FOUND, localizedMessage, null, null);
//	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//	    }
//
//	    @ExceptionHandler(InvalidDataException.class)
//	    public final ResponseEntity<ValidatorResponse<?>> handleInvalidDataException(InvalidDataException ex, WebRequest request) {
//	        String localizedMessage = getLocalizedMessage(ExceptionMessageCode.INVALID_DATA);
//	        ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.BAD_REQUEST, localizedMessage, null, null);
//	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//	    }
//
//	    @ExceptionHandler(DuplicateBookException.class)
//	    public final ResponseEntity<ValidatorResponse<?>> handleDuplicateBookException(DuplicateBookException ex, WebRequest request) {
//	        String localizedMessage = getLocalizedMessage(ExceptionMessageCode.DUPLICATE_BOOK);
//	        ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.UNPROCESSABLE_ENTITY, localizedMessage, null, null);
//	        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
//	    }
//
//	    private String getLocalizedMessage(String messageCode) {
//	        return messageSource.getMessage(messageCode, null, LocaleContextHolder.getLocale());
//	    }
//
//	    private String getLocalizedMessage(ExceptionMessageCode code) {
//	        return getLocalizedMessage(code.getCode());
//	    }
//}




//기존 동작 코드 보관
@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.BAD_REQUEST, StatusCode.BAD_REQUEST_MESSAGE, null, null);
	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	


	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//	    Map<String, String> errors = new HashMap<>();
//	    ex.getBindingResult().getAllErrors().forEach((error) -> {
//	        String fieldName = ((FieldError) error).getField();	        
//	        String errorCode = error.getDefaultMessage();
//	        errors.put(fieldName, errorCode);
//	    });
//	   	    
//	    ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.UNPROCESSABLE_ENTITY, StatusCode.UNPROCESSABLE_ENTITY_MESSAGE, null, errors);
//	    return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
//
//	}
//	
	

//	@ExceptionHandler(BookNotFoundException.class)
//	public final ResponseEntity<ValidatorResponse<?>> handleBookNotFoundException(BookNotFoundException ex, WebRequest request, Locale locale) {
//	    String localizedMessage = messageSource.getMessage("book.error.notfound", null, locale);
//	    ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.NOT_FOUND, localizedMessage, null, null);
//	    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public final ResponseEntity<ValidatorResponse<?>> handleBookNotFoundException(BookNotFoundException ex, WebRequest request) {
	    ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.NOT_FOUND, ex.getMessage(), null, null);
	    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidDataException.class)
	public final ResponseEntity<ValidatorResponse<?>> handleInvalidDataException(InvalidDataException ex, WebRequest request) {
	    ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.BAD_REQUEST, ex.getMessage() != null ? ex.getMessage() : StatusCode.BAD_REQUEST_MESSAGE, null, null);
	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DuplicateBookException.class)
	public final ResponseEntity<ValidatorResponse<?>> handleDuplicateBookException(DuplicateBookException ex, WebRequest request) {
	    ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.UNPROCESSABLE_ENTITY, ex.getMessage() != null ? ex.getMessage() : StatusCode.UNPROCESSABLE_ENTITY_MESSAGE, null, null);
	    return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
	}   
}
	
// 버리기전 코드	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//	    Map<String, String> errors = new HashMap<>();
//	    ex.getBindingResult().getAllErrors().forEach((error) -> {
//	        String fieldName = ((FieldError) error).getField();
//	        String errorMessage = error.getDefaultMessage();
//	        errors.put(fieldName, errorMessage);
//	    });
//	    ValidatorResponse<?> response = new ValidatorResponse<>(StatusCode.BAD_REQUEST, StatusCode.BAD_REQUEST_MESSAGE, null, errors);
//	    return new ResponseEntity<>(response, status);
//	}
//}
