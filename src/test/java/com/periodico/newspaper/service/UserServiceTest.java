package com.periodico.newspaper.service;
import com.periodico.newspaper.model.User;
import com.periodico.newspaper.repository.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @SuppressWarnings("null")
    @Test
    public void whenCreateUser_shouldReturnCreatedResponse() {

        User user = new User();
        user.setName("Testing");
        user.setLastName("Mockito");
        user.setEmail("testing@gmail.com");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(null);

        when(userRepository.save(user)).thenReturn(user);

        ResponseEntity<Object> response = userService.createUser(user);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        Object body = response.getBody();
        assertThat(body).isNotNull(); 
        User createdUser = (User) body; 
        assertThat(createdUser.getName()).isEqualTo("Testing");
        assertThat(createdUser.getLastName()).isEqualTo("Mockito");
        assertThat(createdUser.getEmail()).isEqualTo("testing@gmail.com");


        verify(userRepository).save(user);
    }
}