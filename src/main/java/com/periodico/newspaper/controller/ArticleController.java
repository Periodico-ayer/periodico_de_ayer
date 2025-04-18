package com.periodico.newspaper.controller;

import org.springframework.web.bind.annotation.RestController;
import com.periodico.newspaper.model.Article;
import com.periodico.newspaper.service.ArticleService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/user/{userId}")
    public ResponseEntity<Object> createArticle(@PathVariable Integer userId, @RequestBody Article article) {
        Integer categoryId = article.getCategory().getId();
        return articleService.createArticle(userId, article, categoryId);
    }

    @GetMapping("/{id}")

    public ResponseEntity<Object> getArticleById(@PathVariable Integer id) {
        return this.articleService.getArticleById(id);
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateArticle(@PathVariable Integer id, @RequestBody Article updatedArticle) {
        return this.articleService.updateArticle(id, updatedArticle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteArticle(@PathVariable Integer id) {
        return this.articleService.deleteArticle(id);
    }
}
