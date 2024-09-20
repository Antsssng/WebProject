package com.example.demo.article.entity;

import com.example.demo.user.entity.UserEntity;
import jakarta.persistence.*;

@Entity
public class LikeEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    ArticleEntity articleEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    UserEntity userEntity;

}
