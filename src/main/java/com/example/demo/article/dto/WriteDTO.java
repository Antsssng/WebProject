package com.example.demo.article.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class WriteDTO {

    private String title;

    private String contents;

    private String img_path;
}
