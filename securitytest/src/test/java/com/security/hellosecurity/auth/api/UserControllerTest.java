package com.security.hellosecurity.auth.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.hellosecurity.auth.domain.request.UserCreate;
import com.security.hellosecurity.auth.repository.UserRepository;
import com.security.hellosecurity.auth.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class UserControllerTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void signup() throws Exception {
        UserCreate userCreate = UserCreate.builder()
                .userId("testId")
                .password("12341234")
                .email("test@test.com")
                .build();

        String json = objectMapper.writeValueAsString(userCreate);
        mockMvc.perform(post("/api/auth/signup")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isConflict())
                .andDo(print());


    }
}