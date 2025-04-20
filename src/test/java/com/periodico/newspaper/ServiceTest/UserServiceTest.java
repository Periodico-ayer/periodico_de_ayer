package com.periodico.newspaper.ServiceTest;
import com.periodico.newspaper.model.User;
import com.periodico.newspaper.repository.UserRepository;
import com.periodico.newspaper.service.UserService;
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

    @Test
    public void whenCreateUser_shouldReturnCreatedResponse() {

        User user = new User();
        user.setName("Testing");
        user.setEmail("testing@email.com");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(null);

        when(userRepository.save(user)).thenReturn(user);

        ResponseEntity<Object> response = userService.createUser(user);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        Object body = response.getBody();
        assertThat(body).isNotNull(); 
        User createdUser = (User) body; 
        assertThat(createdUser.getName()).isEqualTo("Testing");

        verify(userRepository).save(user);
    }
}