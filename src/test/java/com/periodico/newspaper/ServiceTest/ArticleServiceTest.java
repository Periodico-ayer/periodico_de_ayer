package com.periodico.newspaper.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.periodico.newspaper.model.Article;
import com.periodico.newspaper.model.Category;
import com.periodico.newspaper.model.User;
import com.periodico.newspaper.repository.ArticleRepository;
import com.periodico.newspaper.repository.CategoryRepository;
import com.periodico.newspaper.repository.UserRepository;
import com.periodico.newspaper.service.ArticleService;


@ExtendWith(MockitoExtension.class)
public class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ArticleService articleService;



    @SuppressWarnings("null")
    @Test
    public void whenCreateArticle_shouldReturnCreatedResponse () {
        Integer userId = 1;
        Integer categoryId = 2;

        User user = new User ();
        user.setId(userId);
        user.setName("Carla");


        Category category = new Category();
        category.setId(categoryId);
        category.setCategory("Tecnología");



        Article article = new Article();
        article.setTitle("Testing Services");
        article.setContent("About hoy to test whit Mockito");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));
        when(articleRepository.findByTitle(anyString())).thenReturn(Optional.empty());
        when(articleRepository.findByContent(anyString())).thenReturn(Optional.empty());
        when(articleRepository.save(any(Article.class))).thenAnswer( inv -> {
            Article saved = inv.getArgument(0);
            saved.setId(100);
            return saved;
            
        });

        var response = articleService.createArticle(userId, article, categoryId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(((Article) response.getBody()).getUser().getName()).isEqualTo("Carla");
    }
}
