package com.example.demo.constants;

public interface StatusCode {
	
    int SUCCESS = 200;
    String SUCCESS_MESSAGE = "Operation successfully completed.";

    int BAD_REQUEST = 400;
    String BAD_REQUEST_MESSAGE = "Bad request.";

    int NOT_FOUND = 404;
    String NOT_FOUND_MESSAGE = "Resource not found.";

    int UNPROCESSABLE_ENTITY = 422;
    String UNPROCESSABLE_ENTITY_MESSAGE = "Validation failed.";

    
    int INTERNAL_SERVER_ERROR = 500;
    String INTERNAL_SERVER_ERROR_MESSAGE = "An unexpected error occurred.";

}
