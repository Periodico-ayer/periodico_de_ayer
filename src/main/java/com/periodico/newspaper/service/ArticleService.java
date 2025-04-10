package com.periodico.newspaper.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.periodico.newspaper.model.Article;
import com.periodico.newspaper.repository.ArticleRepository;

@Service
public class ArticleService {

private final ArticleRepository articleRepository;

public ArticleService(ArticleRepository articleRepository){
this.articleRepository = articleRepository;
}

public ResponseEntity<Object> createArticle(Article article){
articleRepository.save(article);
return new ResponseEntity<>(article, HttpStatus.CREATED);

}

}