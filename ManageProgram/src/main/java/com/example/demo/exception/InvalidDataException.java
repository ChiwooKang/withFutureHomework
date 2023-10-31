package com.example.demo.exception;

import com.example.demo.constants.ExceptionMessageCode;

public class InvalidDataException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = ExceptionMessageCode.INVALID_DATA.getCode();

    public InvalidDataException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidDataException(String customMessage) {
        super(customMessage != null && !customMessage.isEmpty() ? customMessage : DEFAULT_MESSAGE);
    }

    public InvalidDataException(ExceptionMessageCode code) {
        super(code != null ? code.getCode() : DEFAULT_MESSAGE);
    }

    public InvalidDataException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public InvalidDataException(String customMessage, Throwable cause) {
        super(customMessage != null && !customMessage.isEmpty() ? customMessage : DEFAULT_MESSAGE, cause);
    }

    public InvalidDataException(String customMessage, ExceptionMessageCode code) {
        super(customMessage != null && !customMessage.isEmpty() ? customMessage : (code != null ? code.getCode() : DEFAULT_MESSAGE));
    }

    public InvalidDataException(String customMessage, ExceptionMessageCode code, Throwable cause) {
        super(customMessage != null && !customMessage.isEmpty() ? customMessage : (code != null ? code.getCode() : DEFAULT_MESSAGE), cause);
    }
}



    