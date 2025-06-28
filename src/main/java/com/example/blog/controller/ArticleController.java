package com.example.blog.controller;

import com.example.blog.dto.ArticleRequest;
import com.example.blog.dto.ArticleResponse;
import com.example.blog.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService service;

    @GetMapping
    public List<ArticleResponse> getArticles(
            @RequestParam(required = false) String tag,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateAfter
    ) {
        return service.getAllArticles(tag, dateAfter != null ? Date.from(dateAfter.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null);
    }

    @GetMapping("/{id}")
    public ArticleResponse getArticle(@PathVariable Long id) {
        return service.getArticle(id);
    }

    @PostMapping
    public ArticleResponse createArticle(@RequestBody @Valid ArticleRequest request) {
        return service.createArticle(request);
    }

    @PutMapping("/{id}")
    public ArticleResponse updateArticle(@PathVariable Long id, @RequestBody @Valid ArticleRequest request) {
        return service.updateArticle(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        service.deleteArticle(id);

        return ResponseEntity.noContent().build();
    }
}
