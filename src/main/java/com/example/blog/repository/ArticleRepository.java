package com.example.blog.repository;

import com.example.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTag(String tag);
    List<Article> findByPublishedAtAfter(Date date);
}
