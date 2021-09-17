package com.blog.restapi_blog.services.serviceimpl;
import  static com.blog.restapi_blog.TestFeatures.*;

import com.blog.restapi_blog.model.PostModel;
import com.blog.restapi_blog.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import  static  org.assertj.core.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {
@Mock
    PostRepository postRepository;
@Autowired
private PostServiceImpl postService;
    @BeforeEach
    void setUp() {
        postService  = new PostServiceImpl(postRepository);

    }

    @Test
    void findAllPost() {
        posts.add(post1);
        posts.add(post2);
        Mockito.when(postRepository.findAll()).thenReturn(posts);
      List<PostModel> postList =  postService.findAllPost();
      assertThat(postList).isSameAs(posts);
    }

    @Test
    void findPostById() {
        Mockito.when(postRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(post1));
       PostModel postModel = postService.findPostById(1);
        assertThat(postModel).isSameAs(post1);

    }

    @Test
    void findByPostByIDAndUserID() {
//        posts.add(post2);
//        posts.add(post1);
//   Mockito.when(postRepository.findPostModelsByIdAndAndUserId(1,1)).thenReturn(posts);
//   List<PostModel>postLists=postService.findByPostByIDAndUserID(1,1);
//   assertThat(postLists).isSameAs(posts);

    }
}