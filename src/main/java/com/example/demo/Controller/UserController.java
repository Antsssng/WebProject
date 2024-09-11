package com.example.demo.Controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Service.UserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/save")
    public String saveUser(UserDTO userDTO) {
        userService.saveUser(userDTO);

        return "/login";
    }

    @PostMapping("/user/delete")
    public String deleteUser(UserDTO userDTO) {
        userService.deleteUser(userDTO);
        return "/index";
    }

    @PostMapping("/user/login")
    public String loginUser(UserDTO userDTO, Model model)
    {
        model.addAttribute("userName", userService.getUserName(userDTO.getUserId()));
        if(userService.loginUser(userDTO))
        {
            return "/index";
        }
        else {
            return "/login";
        }
    }
}
