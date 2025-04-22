package com.periodico.newspaper.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.periodico.newspaper.DotenvTestInitializer;
import com.periodico.newspaper.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(initializers = DotenvTestInitializer.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateUser() throws Exception {
        User user = new User();
        user.setName("Carla1");
        user.setLastName("Tester1");
        user.setEmail("carla1@test.com");

        mockMvc.perform(post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
            .andExpect(status().isCreated()) 
            .andExpect(jsonPath("$.name").value("Carla1"))
            .andExpect(jsonPath("$.lastName").value("Tester1"))
            .andExpect(jsonPath("$.email").value("carla1@test.com"));
    }
}
