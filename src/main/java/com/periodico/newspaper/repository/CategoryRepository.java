package com.periodico.newspaper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.periodico.newspaper.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
