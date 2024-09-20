package com.example.demo.article.service;

import com.example.demo.article.dto.WriteDTO;
import com.example.demo.article.entity.ArticleEntity;
import com.example.demo.article.repository.ArticleRepository;
import com.example.demo.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WriteService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    WriteService(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    public void writeProcess(WriteDTO writeDTO, String userId) {

        String title = writeDTO.getTitle();
        String contents = writeDTO.getContents();
        String img_path = writeDTO.getImg_path();

        ArticleEntity data = new ArticleEntity();

        data.setUserEntity(userRepository.findByUserId(userId));
        data.setTitle(title);
        data.setContents(contents);
        data.setImg_path(img_path);
        data.setCreated_at(new java.sql.Date(System.currentTimeMillis()));
        data.setUpdated_at(new java.sql.Date(System.currentTimeMillis()));
        data.setLike_users(new ArrayList<>());
        data.setView_count(0);

        articleRepository.save(data);
    }
}
