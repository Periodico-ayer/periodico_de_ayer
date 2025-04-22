package com.periodico.newspaper;

import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.periodico.newspaper.controller.UserController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; 


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;

@WebMvcTest
@Import(UserController.class)
@ActiveProfiles("test")

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"FemCoders\",\"lastName\":\"SomosFemCoders\",\"email\":\"fem.coders@example.com\"}"))
                .andExpect(status().isOk());
    }
}
