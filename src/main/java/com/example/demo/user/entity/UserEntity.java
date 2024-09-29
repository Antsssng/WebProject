package com.example.demo.user.entity;

import com.example.demo.article.entity.LikeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userId")
    private String userId;

    private String userPw;

    private String role;

//    @OneToMany(mappedBy = "userEntity")
//    private List<LikeEntity> likeEntity = new ArrayList<>();
}
