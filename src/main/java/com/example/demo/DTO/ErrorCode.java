package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_USER_NAME(3000, "User name is duplicated.");

    private int errorCode;
    private String message;
}
