package com.periodico.newspaper.controller;

import org.springframework.web.bind.annotation.RestController;
import com.periodico.newspaper.model.Article;
import com.periodico.newspaper.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;

    }

    @PostMapping("/users/{id}") 
    public ResponseEntity<Object> createArticle(@Valid @RequestBody Article article) {
        return articleService.createArticle(article);
    }
}
