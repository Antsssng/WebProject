package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/react")
    public String test() {
        return "Hello, world!";
    }

    @PostMapping("/users/register")
    public String register() {
        return "Success";
    }
}