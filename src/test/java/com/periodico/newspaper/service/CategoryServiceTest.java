package com.periodico.newspaper.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.periodico.newspaper.model.Category;
import com.periodico.newspaper.repository.CategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

@Mock
private CategoryRepository categoryRepository;

@InjectMocks
private CategoryService categoryService;

@SuppressWarnings("null")
@Test
public void whenCerateCategory_shouldReturnCreatedResponse(){

    Category category = new Category ();
    category.setCategory("Technology");

    when(categoryRepository.save(category)).thenReturn(category);
    ResponseEntity<Object> response = categoryService.createCategory(category);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    
    Object body = response.getBody();
    assertThat(body).isNotNull();
    Category createdCategory = (Category) body;
    assertThat(createdCategory.getCategory()).isEqualTo("Technology"); 
}

}
