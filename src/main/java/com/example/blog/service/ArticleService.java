package com.example.blog.service;

import com.example.blog.dto.ArticleRequest;
import com.example.blog.dto.ArticleResponse;

import java.util.Date;
import java.util.List;

public interface ArticleService {
    List<ArticleResponse> getAllArticles(String tag, Date afterDate);
    ArticleResponse getArticle(Long id);
    ArticleResponse createArticle(ArticleRequest request);
    ArticleResponse updateArticle(Long id, ArticleRequest request);
    void deleteArticle(Long id);
}
