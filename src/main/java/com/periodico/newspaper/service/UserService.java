package com.periodico.newspaper.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.periodico.newspaper.Validation.EmailAlreadyExistsException;
// import com.periodico.newspaper.Validation.EmailAlreadyExistsException;
import com.periodico.newspaper.model.User;
import com.periodico.newspaper.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ResponseEntity<Object> createUser(User user){

        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new EmailAlreadyExistsException("ERROR: ya existe un usuario cadastrado con ese correo. Intente con otro.");
        }

        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);

    }


}
