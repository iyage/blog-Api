package com.blog.restapi_blog.services.serviceimpl;

import com.blog.restapi_blog.model.Comments;
import com.blog.restapi_blog.repository.CommentsRepository;
import com.blog.restapi_blog.repository.PostRepository;
import com.blog.restapi_blog.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import  static  com.blog.restapi_blog.TestFeatures.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import  static org.assertj.core.api.Assertions.*;



@ExtendWith(MockitoExtension.class)
class CommentsServiceImplTest {
    @Mock
    private PostRepository postRepository;
    @Mock
   private CommentsRepository commentsRepository;
    @Mock
    private  UserRepository userRepository;
    private  CommentsServiceImpl commentsService;


    @BeforeEach
    void setUp() {
      commentsService = new CommentsServiceImpl();
      commentsService.setCommentsRepository(commentsRepository);
      commentsService.setPostRepository(postRepository);
      commentsService.setUserRepository(userRepository);
    }

//    @Test
//    void makeCommments() {
//     String content = "test comment";
//     Mockito.when(commentsRepository.save(any())).thenReturn(saveNewComment(content,post1,user1));
//     Mockito.when(postRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(post1));
//     Mockito.when(userRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(user1));
//    Comments comment = commentsService.makeCommments(1,1,content);
//     assertEquals(commentsList.size(),1);
//     assertThat(comment.getContent()).isSameAs("test comment");
//
//    }

    @Test
    void editComment() {
     Mockito.when(commentsRepository.save(any())).thenReturn(comment1);
     Mockito.when(commentsRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(comment1));
     commentsService.editComment(1,"updated content");
     assertThat(comment1.getContent()).isSameAs("updated content");
    }

    @Test
    void findAllUserComments() {
     commentsList.add(comment1);
     Mockito.when(commentsRepository.findAllByUserId(1)).thenReturn(commentsList);
     List<Comments> listOfCommentByUser= commentsService.findAllUserComments(1);
     assertThat(listOfCommentByUser).isSameAs(commentsList);

    }

    @Test
    void findAllpostComments() {
     commentsList.add(comment1);
     Mockito.when(commentsRepository.findAllByPostId(1)).thenReturn(commentsList);
     List<Comments> allPostComment= commentsService.findAllpostComments(1);
     assertThat(allPostComment).isSameAs(commentsList);
    }

    @Test
    void findUserCommentOnAPost() {
     Mockito.when(commentsRepository.findByUserIdAndPostId(1,1)).thenReturn(commentsList);
     List<Comments> allcommentToAPostByAUser = commentsService.findUserCommentOnAPost(1,1);
     assertThat(allcommentToAPostByAUser).isSameAs(commentsList);
    }

    @Test
    void deleteComment() {
     Mockito.when(commentsRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(comment1));
    commentsService.deleteComment(1);
    Mockito.verify(commentsRepository).delete(comment1);
    }

}