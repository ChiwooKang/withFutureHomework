package com.example.demo.controller;

public class handlerout {
	
//	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//		ValidatorResponse<object> errorResponse = new ValidatorResponse(StatusCode.BAD_REQUEST,"잘못된 제이슨 응답입니다.");
//	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//	}
//	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(
//			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//		return handleExceptionInternal(ex, null, headers, status, request);
//	}
//
//
//
//	
//	 @ExceptionHandler(BookNotFoundException.class)
//	    public final ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException ex, WebRequest request) {
//	        ErrorResponse errorResponse = new ErrorResponse(StatusCode.NOT_FOUND, ex.getMessage() != null ? ex.getMessage() : StatusCode.NOT_FOUND_MESSAGE);
//	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//	    }
//	 
//
//
//
//	    @ExceptionHandler(InvalidDataException.class)
//	    public final ResponseEntity<ErrorResponse> handleInvalidDataException(InvalidDataException ex, WebRequest request) {
//	        ErrorResponse errorResponse = new ErrorResponse(StatusCode.BAD_REQUEST, ex.getMessage() != null ? ex.getMessage() : StatusCode.BAD_REQUEST_MESSAGE);
//	        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//	    }
//
//	    @ExceptionHandler(DuplicateBookException.class)
//	    public final ResponseEntity<ErrorResponse> handleDuplicateBookException(DuplicateBookException ex, WebRequest request) {
//	        ErrorResponse errorResponse = new ErrorResponse(StatusCode.UNPROCESSABLE_ENTITY, ex.getMessage() != null ? ex.getMessage() : StatusCode.UNPROCESSABLE_ENTITY_MESSAGE);
//	        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
//	    }
//	    

//    @ExceptionHandler(BookNotFoundException.class)
//    public final ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException ex, WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(InvalidDataException.class)
//    public final ResponseEntity<ErrorResponse> handleInvalidDataException(InvalidDataException ex, WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(DuplicateBookException.class)
//    public final ResponseEntity<ErrorResponse> handleDuplicateBookException(DuplicateBookException ex, WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
//        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
//    }
    
//    @ExceptionHandler(InvalidDataException.class)
//    public final ResponseEntity<ErrorResponse> handleInvalidDataException(InvalidDataException ex, WebRequest request) {
//        String requestURL = ((ServletWebRequest)request).getRequest().getRequestURI().toString();
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage() + " URL: " + requestURL);
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }

}
