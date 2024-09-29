package com.example.demo.user.controller;

import com.example.demo.jwt.LoginFilter;
import com.example.demo.user.dto.LoginDTO;
import com.example.demo.user.service.LoginService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class LoginController {

    private final LoginService loginService;

    public LoginController (LoginService loginService) {

        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(LoginDTO loginDTO) {

        loginService.loginProcess(loginDTO);

        return "login";
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(
//            @ApiParam(value = "로그인 요청 정보", required = true)
//            @RequestBody LoginDTO loginDTO) {
//
//        // JWT 생성 및 검증 로직
//        return ResponseEntity.ok("JWT 토큰 반환 예시");
//    }
}
