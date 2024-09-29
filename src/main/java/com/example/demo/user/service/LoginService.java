package com.example.demo.user.service;

import com.example.demo.jwt.JWTUtiil;
import com.example.demo.user.dto.LoginDTO;
import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.repository.UserRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final JWTUtiil jwtUtiil;

    public LoginService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, JWTUtiil jwtUtiil)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtUtiil = jwtUtiil;
    }

    public String loginProcess(LoginDTO loginDTO) {

        String userId = loginDTO.getUserId();
        String userPw = loginDTO.getUserPw();

        UserEntity userEntity = userRepository.findByUserId(userId);

        if (bCryptPasswordEncoder.matches(userPw, userEntity.getUserPw())) {

            String token = jwtUtiil.createJwt(userId, userEntity.getRole(), 60*60*10000L);
            return token;
        }
        else return "";
    }
}
