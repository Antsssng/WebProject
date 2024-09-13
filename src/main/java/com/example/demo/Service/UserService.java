package com.example.demo.Service;

import com.example.demo.DTO.CustomException;
import com.example.demo.DTO.ErrorCode;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveUser(UserDTO userDTO) {

         if (userRepository.existsByUserId(userDTO.getUserId())) {
            throw new CustomException(ErrorCode.DUPLICATED_USER_NAME, "중복된 아이디 입니다.");
         }

        //패스워드 암호화
        userDTO.setUserPw(passwordEncoder.encode(userDTO.getUserPw()));
        userRepository.save(userDTO.toEntity());
    }

    public void deleteUser(UserDTO userDTO) {
        String pw = userRepository.findByUserId(userDTO.getUserId()).getPassword();

        if (passwordEncoder.matches(userDTO.getUserPw(), pw))
        {
            userRepository.deleteById(userDTO.getUserId());
        }
    }

    public boolean loginUser(UserDTO userDTO)
    {
        String pw = userRepository.findByUserId(userDTO.getUserId()).getPassword();

        if (passwordEncoder.matches(userDTO.getUserPw(), pw))
        {
            return true;
        }
        else return false;
    }

    public String getUserName(String userId)
    {
        return userRepository.findByUserId(userId).getUsername();
    }
}
