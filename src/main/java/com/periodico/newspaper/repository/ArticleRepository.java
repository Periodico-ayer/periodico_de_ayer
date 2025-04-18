package com.periodico.newspaper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.periodico.newspaper.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
