package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 내가 지정한 클래스내에서만 오류처리하기
@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;
    @Override
    public String toString() {
        if(message == null) {
            return errorCode.getMessage();
        }

        return String.format("%s. %s", errorCode.getMessage(), message);
    }
}