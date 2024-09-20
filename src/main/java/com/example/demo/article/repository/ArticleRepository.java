package com.example.demo.article.repository;

import com.example.demo.article.entity.ArticleEntity;
import com.example.demo.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
}