package com.example.demo.exception;

import com.example.demo.constants.ExceptionMessageCode;

public class BookNotFoundException extends RuntimeException {
    
    private static final String DEFAULT_MESSAGE = ExceptionMessageCode.BOOK_NOT_FOUND.getCode();

    public BookNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public BookNotFoundException(String customMessage) {
        super(customMessage != null && !customMessage.isEmpty() ? customMessage : DEFAULT_MESSAGE);
    }

    public BookNotFoundException(ExceptionMessageCode code) {
        super(code != null ? code.getCode() : DEFAULT_MESSAGE);
    }

    public BookNotFoundException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public BookNotFoundException(String customMessage, Throwable cause) {
        super(customMessage != null && !customMessage.isEmpty() ? customMessage : DEFAULT_MESSAGE, cause);
    }

    public BookNotFoundException(String customMessage, ExceptionMessageCode code) {
        super(customMessage != null && !customMessage.isEmpty() ? customMessage : (code != null ? code.getCode() : DEFAULT_MESSAGE));
    }

    public BookNotFoundException(String customMessage, ExceptionMessageCode code, Throwable cause) {
        super(customMessage != null && !customMessage.isEmpty() ? customMessage : (code != null ? code.getCode() : DEFAULT_MESSAGE), cause);
    }
}



//public class BookNotFoundException extends RuntimeException {
//    
//    public BookNotFoundException() {
//        super("Book not found.");
//    }
//
//    public BookNotFoundException(String message) {
//        super(message);
//    }
//
//    public BookNotFoundException(String message, Throwable cause) {
//        super(message, cause);
//    }
//
//    public BookNotFoundException(Throwable cause) {
//        super(cause);
//    }
//}
