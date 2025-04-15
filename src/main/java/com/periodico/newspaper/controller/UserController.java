package com.periodico.newspaper.controller;

import org.springframework.http.ResponseEntity;
// import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.periodico.newspaper.model.User;
import com.periodico.newspaper.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;

  }

  // @PostMapping
  // public ResponseEntity<Object> createUser(@Valid @RequestBody User user, BindingResult bindingResult){
  //   if (bindingResult.hasErrors()){
  //     return ResponseEntity.badRequest().body("No se ha podido crear el usuario");
  //   }
  //   userService.createUser(user);
  //   return ResponseEntity.ok("El usuario ha sido creado con éxito");
  // }

  @PostMapping
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
    return userService.createUser(user);
  }
  
}

