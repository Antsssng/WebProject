package com.example.demo.article.repository;

import com.example.demo.article.entity.ArticleEntity;
import com.example.demo.article.entity.LikeEntity;
import com.example.demo.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Integer> {

    List<LikeEntity> findByUserEntity(UserEntity userEntity);

    List<LikeEntity> findByArticleEntity(ArticleEntity articleEntity);

    Boolean existsByUserEntity(UserEntity userEntity);

    Boolean existsByArticleEntity(ArticleEntity articleEntity);
}
