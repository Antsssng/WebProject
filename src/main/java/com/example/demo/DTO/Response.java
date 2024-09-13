package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public class Response<T> {
    private String status;
    private T body;

    public static Response<Void> runtimeError(String Message) {
        return new Response(Message, null);
    }

    public static Response<Void> error(ErrorCode code) {

        Map<String, Object> result = new HashMap<>();
        result.put("errorCode", code.getErrorCode());
        result.put("errorMessage", code.getMessage());

        return new Response("fail", result);
    }

    public static <T> Response<T> success(T result){
        return new Response("success", result);
    }
}


