package com.periodico.newspaper.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.periodico.newspaper.model.Article;
import com.periodico.newspaper.model.User;
import com.periodico.newspaper.repository.ArticleRepository;
import com.periodico.newspaper.repository.UserRepository;

@Service
public class DatabaseService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    
    public DatabaseService(ArticleRepository articleRepository,
                            UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }
    
    public ResponseEntity<Object> createArticle(Article article,
                                                User user){
        articleRepository.save(article);
        userRepository.save(user);
        Map<String, Object> response = new HashMap<>();
        response.put("article", article);
        response.put("user", user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}