package com.periodico.newspaper.service;

import java.util.List;

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
return new ResponseEntity<>(articleRepository.save(article), HttpStatus.CREATED);
}

public List<Article> getAllArticles(){
    return this.articleRepository.findAll();
}

}