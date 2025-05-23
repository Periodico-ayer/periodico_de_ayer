package com.periodico.newspaper.controller;
import com.periodico.newspaper.model.Category;
import com.periodico.newspaper.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/categories")

public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @PostMapping
  public ResponseEntity<Object> createCategory(@Valid @RequestBody Category category) {
    return categoryService.createCategory(category);
  }

}
