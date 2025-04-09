package com.periodico.newspaper.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.periodico.newspaper.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
