package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/api/hello")
    public String test() {
        return "Hello, world!";
    }
}
