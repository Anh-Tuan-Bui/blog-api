package com.example.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleRequest {

    @NotBlank(message = "Title is not blank")
    @Size(max = 100, message = "Maximum length of title is 100 characters")
    String title;

    @NotBlank(message = "Content is not blank")
    String content;

    @NotBlank(message = "Author is not blank")
    String author;

    String tag;
}
