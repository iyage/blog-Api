package com.blog.restapi_blog.services.serviceimpl;
import  static  com.blog.restapi_blog.TestFeatures.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.blog.restapi_blog.model.PostModel;
import com.blog.restapi_blog.model.UserModel;
import com.blog.restapi_blog.repository.PostRepository;
import com.blog.restapi_blog.repository.UserRepository;
import com.blog.restapi_blog.repository.PostLikesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class UserServiceImplTest {
    @Autowired
private MockMvc mockMvc;
    @Mock
    private PostLikesRepository postLikesRepository;
    @Mock
   private UserRepository userRepository;
    @Mock
    private PostRepository postRepository;
    private  UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
        userService.setUserRepository(userRepository);
        userService.setPostRepository(postRepository);
        userService.setPostLikesRepository(postLikesRepository);
    }

    @Test
    void userIsRegistered() {
        Mockito.when(userRepository.save(user1))
                .thenReturn(registerNewUser(user1));
        userService.registerUser(user1);
  assertEquals(users.size(),1);
    }

    @Test
    void userIsLogin() {
        Mockito.when(userRepository.findByUsernameAndPassword("yage","1234"))
                .thenReturn(java.util.Optional.ofNullable(user1));
      UserModel user =  userService.Userlogin(user1.getUsername(),user1.getPassword());
      assertThat(user).isSameAs(user1);
    }

    @Test
    void postWasSaved() {
        Mockito.when(postRepository.save(post1)).thenReturn(saveNewPostr(post1));
       PostModel postModel =  userService.savePost(post1);
       assertEquals(posts.size(),1);
    }

    @Test
    void deleteAPost() {
        userService.deletePost(1);
        Mockito.verify(postRepository).deleteById(any());
    }

    @Test
    void likeAapost() {
        Mockito.when(postLikesRepository.findAllByUserIdAndPsstId(user1.getId(),post1.getId()))
                .thenReturn(java.util.Optional.ofNullable(findPostLikes(user1.getId(),post1.getId())));
  Mockito.lenient().when((postLikesRepository.save(postlike)))
          .thenReturn(likeadded(postlike));
  Mockito.when(postRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(post1));
  Mockito.when(userRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(user1));
  userService.userLikeAPost(user1.getId(),post1.getId());
  assertEquals(postLikesModelList.size(),1);

    }
    @Test
    void disLikeAapost() {
        postLikesModelList.add(postlike);
        Mockito.when(postLikesRepository.findAllByUserIdAndPsstId(user1.getId(),post1.getId()))
                .thenReturn(java.util.Optional.ofNullable(findPostLikes(user1.getId(),post1.getId())));
        Mockito.lenient().when((postLikesRepository.save(postlike)))
                .thenReturn(likeadded(postlike));
        Mockito.lenient().when(postRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(post1));
        Mockito.lenient().when(userRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(user1));
        userService.userLikeAPost(user1.getId(),post1.getId());
        Mockito.verify(postLikesRepository).delete(postlike);


    }


}