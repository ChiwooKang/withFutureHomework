package com.example.demo.model.response;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true) // 빌더 패턴 사용할꺼면 올 아규먼츠 삭제하고 셋하는 메서드 하나 새로 뽑을것
public class ValidatorResponse<T> {

    private int status;
    private String message;
    private T data;
    private Map<String, String> errors;

    // 기본 메시지를 위한 상수
    private static final String DEFAULT_SUCCESS_MESSAGE = "Operation successful";
    private static final String DEFAULT_ERROR_MESSAGE = "Operation failed";

    // 성공 응답
    public static <T> ValidatorResponse<T> success(T data) {
        return ValidatorResponse.<T>builder()
                .status(200)
                .message(DEFAULT_SUCCESS_MESSAGE)
                .data(data)
                .build();
    }

    // 에러 응답
    public static ValidatorResponse<Object> error(int status, String message) {
        return ValidatorResponse.builder()
                .status(status)
                .message(message != null ? message : DEFAULT_ERROR_MESSAGE)
                .errors(new HashMap<>())
                .build();
    }

  
}
