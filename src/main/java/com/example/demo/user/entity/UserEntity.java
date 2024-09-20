package com.example.demo.user.entity;

import com.example.demo.article.entity.ArticleEntity;
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

    private String userId;

    private String userPw;

    private String role;

//    @OneToMany(mappedBy = "ArticleEntity", cascade = CascadeType.ALL)
//    private List<ArticleEntity> articles = new ArrayList<>();
}
