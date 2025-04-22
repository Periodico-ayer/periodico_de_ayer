package com.periodico.newspaper.service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.periodico.newspaper.Validation.EmailAlreadyExistsException;
import com.periodico.newspaper.model.User;
import com.periodico.newspaper.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ResponseEntity<Object> createUser(User user){

        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new EmailAlreadyExistsException("[ERROR]: Ya existe un usuario cadastrado con ese correo. Intente con otro.");
        }
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    public ResponseEntity<Object> deleteUser(Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        userRepository.delete(userOptional.get());
        return ResponseEntity.ok().build();
    }


}
