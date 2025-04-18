package com.periodico.newspaper.service;

import java.util.Optional;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.periodico.newspaper.model.Article;
import com.periodico.newspaper.model.User;
import com.periodico.newspaper.repository.ArticleRepository;
import com.periodico.newspaper.repository.UserRepository;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleService(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> createArticle(Integer userId, Article article) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();

        }

        article.setUser(userOptional.get());
        return new ResponseEntity<>(articleRepository.save(article), HttpStatus.CREATED);

    }

    public List<Article> getAllArticles() {
        return this.articleRepository.findAll();
    }

    public ResponseEntity<Object> getArticleById(Integer id) {
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (!articleOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Article article = articleOptional.get();
        return ResponseEntity.ok(article);

    }

    public ResponseEntity<Object> updateArticle(Integer id, Article updateArticle) {
        Optional<Article> articleOptional = articleRepository.findById(id);

        if (!articleOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Article existingArticle = articleOptional.get();

        existingArticle.setTitle(updateArticle.getTitle());
        existingArticle.setContent(updateArticle.getContent());
        articleRepository.save(existingArticle);
        return ResponseEntity.ok(existingArticle);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity<Object> deleteArticle(Integer id) {
        Optional<Article> articleOptional = articleRepository.findById(id);

        if (!articleOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Article article = articleOptional.get();

        articleRepository.deleteById(article.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
