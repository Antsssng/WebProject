package com.example.demo.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Iterator;

@Controller
@ResponseBody
@Tag(name = "메인 API", description = "메인 API입니다.")
public class MainController {

    @GetMapping("/")
    public String mainP(){

        return "Main Controller";
    }


    @GetMapping("/users")
    public String userP(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String name = authentication.getName();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();

        return "Main Controller " + name + " " + role + "\n";
    }
}
