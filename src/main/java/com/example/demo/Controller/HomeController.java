package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() { return "/index"; }

    @RequestMapping("/join")
    public String join() {
        return "/join";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "/login";
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "/hello";
    }
}
