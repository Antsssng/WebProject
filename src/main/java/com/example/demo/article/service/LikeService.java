package com.example.demo.article.service;

import com.example.demo.article.dto.LikeDTO;
import com.example.demo.article.entity.ArticleEntity;
import com.example.demo.article.entity.LikeEntity;
import com.example.demo.article.repository.ArticleRepository;
import com.example.demo.article.repository.LikeRepository;
import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.repository.UserRepository;
import org.hibernate.result.UpdateCountOutput;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public LikeService(LikeRepository likeRepository, ArticleRepository articleRepository, UserRepository userRepository) {

        this.likeRepository = likeRepository;
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    public void likeProcess(LikeDTO likeDTO, String userId) {

        ArticleEntity articleEntity = articleRepository.findById(likeDTO.getArticleId());
        UserEntity userEntity = userRepository.findByUserId(userId);

        //존재 여부 검사
        List<LikeEntity> likeList = likeRepository.findByUserEntity(userEntity);
        for (int i = 0; i < likeList.size(); i++) {

            if(articleEntity.getId() == likeList.get(i).getArticleEntity().getId()) {
                System.out.println("중복");
                return;
            }
        }

        LikeEntity data = new LikeEntity();

        data.setArticleEntity(articleEntity);
        data.setUserEntity(userEntity);

        likeRepository.save(data);
    }

    public String getArticleInf(String userId) {

        UserEntity userEntity = userRepository.findByUserId(userId);
        List<LikeEntity> likeList = likeRepository.findByUserEntity(userEntity);

        String returnString = "";

        for (int i = 0; i < likeList.size(); i++) {
            returnString = returnString.concat(likeList.get(i).getArticleEntity().getTitle() + " ");
        }

        return  returnString;
    }
}
