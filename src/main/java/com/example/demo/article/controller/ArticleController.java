package com.example.demo.article.controller;

import com.example.demo.article.dto.WriteDTO;
import com.example.demo.article.service.WriteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ArticleController {

    private final WriteService writeService;

    public ArticleController(WriteService writeService) {

        this.writeService = writeService;
    }

    @PostMapping("/write")
    public String writeProcess(WriteDTO writeDTO) {

        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        writeService.writeProcess(writeDTO, userId);

        return "Article Controller";
    }
}
