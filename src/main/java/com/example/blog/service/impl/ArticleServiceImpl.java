package com.example.blog.service.impl;

import com.example.blog.dto.ArticleRequest;
import com.example.blog.dto.ArticleResponse;
import com.example.blog.entity.Article;
import com.example.blog.exception.NotFoundException;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.service.ArticleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArticleServiceImpl implements ArticleService {

    ArticleRepository repository;
    ModelMapper mapper;

    @Override
    public List<ArticleResponse> getAllArticles(String tag, Date afterDate) {
        List<Article> articles;

        if (tag != null && afterDate != null) {
            articles = repository.findAll().stream()
                    .filter(a -> a.getTag().equalsIgnoreCase(tag) && a.getPublishedAt().after(afterDate))
                    .toList();
        } else if (tag != null) {
            articles = repository.findByTag(tag);
        } else if (afterDate != null) {
            articles = repository.findByPublishedAtAfter(afterDate);
        } else {
            articles = repository.findAll();
        }

        return articles.stream()
                .map(article -> mapper.map(article, ArticleResponse.class))
                .toList();
    }

    @Override
    public ArticleResponse getArticle(Long id) {
        return repository.findById(id)
                .map(article1 -> mapper.map(article1, ArticleResponse.class))
                .orElseThrow(() -> new NotFoundException("Article not found with id: " + id));
    }

    @Override
    public ArticleResponse createArticle(ArticleRequest request) {
        Article article = new Article();
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());
        article.setAuthor(request.getAuthor());
        article.setTag(request.getTag());
        article.setPublishedAt(new Date());

        return mapper.map(repository.save(article), ArticleResponse.class);
    }

    @Override
    public ArticleResponse updateArticle(Long id, ArticleRequest request) {
        Article exist = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Article not found with id: " + id));

        exist.setTitle(request.getTitle());
        exist.setContent(request.getContent());
        exist.setAuthor(request.getAuthor());
        exist.setTag(request.getTag());

        return mapper.map(repository.save(exist), ArticleResponse.class);
    }

    @Override
    public void deleteArticle(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Article not found with id: " + id);
        }

        repository.deleteById(id);
    }
}
