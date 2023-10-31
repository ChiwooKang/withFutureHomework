package com.example.demo.exception;

import com.example.demo.constants.ExceptionMessageCode;

public class DuplicateBookException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = ExceptionMessageCode.DUPLICATE_BOOK_NUMBER.getCode();

    public DuplicateBookException() {
        super(DEFAULT_MESSAGE);
    }

    public DuplicateBookException(String customMessage) {
        super(customMessage != null && !customMessage.isEmpty() ? customMessage : DEFAULT_MESSAGE);
    }

    public DuplicateBookException(ExceptionMessageCode code) {
        super(code != null ? code.getCode() : DEFAULT_MESSAGE);
    }

    public DuplicateBookException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public DuplicateBookException(String customMessage, Throwable cause) {
        super(customMessage != null && !customMessage.isEmpty() ? customMessage : DEFAULT_MESSAGE, cause);
    }

    public DuplicateBookException(String customMessage, ExceptionMessageCode code) {
        super(customMessage != null && !customMessage.isEmpty() ? customMessage : (code != null ? code.getCode() : DEFAULT_MESSAGE));
    }

    public DuplicateBookException(String customMessage, ExceptionMessageCode code, Throwable cause) {
        super(customMessage != null && !customMessage.isEmpty() ? customMessage : (code != null ? code.getCode() : DEFAULT_MESSAGE), cause);
    }
}




//public class DuplicateBookException extends RuntimeException {
//    
//    public DuplicateBookException() {
//        super("Duplicate book entry found.");
//    }
//
//    public DuplicateBookException(String message) {
//        super(message);
//    }
//
//    public DuplicateBookException(String message, Throwable cause) {
//        super(message, cause);
//    }
//
//    public DuplicateBookException(Throwable cause) {
//        super(cause);
//    }
//}
