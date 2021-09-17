package com.blog.restapi_blog.restcontroller;
import  static  com.blog.restapi_blog.TestFeatures.*;

import com.blog.restapi_blog.model.UserModel;
import com.blog.restapi_blog.repository.UserRepository;
import com.blog.restapi_blog.services.serviceimpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
    class UserControllerTest {
   @Autowired
    private MockMvc mockMvc;
    @MockBean
    UserServiceImpl userService;
    @MockBean
 UserRepository userRepository;
 @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
        userService.setUserRepository(userRepository);

    }

    @Test
    void registerUser() throws Exception {
        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        String user = "{\"firstName\":\"\",\"lastName\":\"Olusoji\",\"Username\":\"bob\"," +
                "\"email\":\"bob@gmail.com\",\"password\":\"1234\"}";
     this.mockMvc.perform(MockMvcRequestBuilders.post("/register")
                     .content(user)
             .contentType(MediaType.APPLICATION_JSON_UTF8))
              .andExpect(MockMvcResultMatchers.status().is(400));
    }
}