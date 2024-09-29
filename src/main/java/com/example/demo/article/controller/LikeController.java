package com.example.demo.article.controller;

import com.example.demo.article.dto.LikeDTO;
import com.example.demo.article.entity.LikeEntity;
import com.example.demo.article.service.LikeService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class LikeController {

    private LikeService likeService;

    public LikeController(LikeService likeService) {

        this.likeService = likeService;
    }

    @PostMapping("/like")
    public String likeProcess(LikeDTO likeDTO) {

        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        likeService.likeProcess(likeDTO, userId);

        return "Like~~";
    }


    @PostMapping("/artInf")
    public String getArti() {

        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

       String a = likeService.getArticleInf(userId);

       return "Like~~ " + a;
    }
}
