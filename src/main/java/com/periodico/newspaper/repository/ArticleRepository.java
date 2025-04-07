package com.periodico.newspaper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.periodico.newspaper.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{}
