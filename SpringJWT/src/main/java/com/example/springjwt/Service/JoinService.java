package com.example.springjwt.Service;

import com.example.springjwt.dto.JoinDTO;
import com.example.springjwt.entity.UserEntity;
import com.example.springjwt.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public void joinProcess(JoinDTO joinDTO) {
        String userId = joinDTO.getUserId();
        String userPw = joinDTO.getUserPw();

        Boolean isExists = userRepository.existsByUserId(userId);

        if (isExists) {
            return;
        }

        UserEntity data = new UserEntity();
        data.setUserId(userId);
        data.setUserPw(bCryptPasswordEncoder.encode(userPw));
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);

    }
}
