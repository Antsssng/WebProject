package com.example.demo.DTO;

import com.example.demo.Entity.UserEntity;
import lombok.Data;

@Data
public class UserDTO {

    private String userId;
    private String userPw;
    private String userName;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .build();
    }

}
