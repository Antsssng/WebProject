package com.example.demo.article.entity;

import com.example.demo.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "articleId")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    //DB에선 작성 안 되지만 양방향 참조를 위해서 변수 설정
    @OneToMany(mappedBy = "articleEntity")
    private List<LikeEntity> likeEntity = new ArrayList<>();

    private String title;

    private String contents;

    private Date created_at;

    private Date updated_at;

    private String img_path;

//    private List<String> like_users;

    private int view_count;
}
