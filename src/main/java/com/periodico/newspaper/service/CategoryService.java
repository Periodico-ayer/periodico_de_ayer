package com.periodico.newspaper.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.periodico.newspaper.Validation.CategoryAlreadyExistsException;
import com.periodico.newspaper.model.Category;
import com.periodico.newspaper.repository.CategoryRepository;

@Service

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<Object> createCategory(Category category) {

        if(categoryRepository.findByCategory(category.getCategory()) != null){
            throw new CategoryAlreadyExistsException("[ERROR]: Ya existe una categoria cadastrada con ese nombre");
        }

        return new ResponseEntity<>(categoryRepository.save(category), HttpStatus.CREATED);
    }

}
