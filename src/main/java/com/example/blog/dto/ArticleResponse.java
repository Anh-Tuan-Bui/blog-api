package com.example.blog.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleResponse {
    Long id;
    String title;
    String content;
    String author;
    String tag;
    Date publishedAt;
}
