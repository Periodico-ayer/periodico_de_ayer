package com.periodico.newspaper.service;

import java.util.Optional;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.periodico.newspaper.Validation.ContentAlreadyExistsException;
import com.periodico.newspaper.Validation.TitleAlreadyExistsException;
import com.periodico.newspaper.model.Article;
import com.periodico.newspaper.model.User;
import com.periodico.newspaper.model.Category;
import com.periodico.newspaper.repository.ArticleRepository;
import com.periodico.newspaper.repository.UserRepository;
import com.periodico.newspaper.repository.CategoryRepository;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public ArticleService(ArticleRepository articleRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<Object> createArticle(Integer userId, Article article, Integer categoryId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        if (!categoryOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        if (article.getTitle() != null && articleRepository.findByTitle(article.getTitle()).isPresent()) {
            throw new TitleAlreadyExistsException("[ERROR]: Ya existe un artículo con el mismo título en la base de datos");
        }
        if (article.getContent() != null && articleRepository.findByContent(article.getContent()).isPresent()) {
            throw new ContentAlreadyExistsException("[ERROR]: Ya existe un artículo con el mismo contenido en la base de datos");
        }

        article.setUser(userOptional.get());
        article.setCategory(categoryOptional.get());
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
