package com.blog.restapi_blog.services.serviceimpl;

import com.blog.restapi_blog.exceptions.ResourceNotFoundException;
import com.blog.restapi_blog.model.Comments;
import com.blog.restapi_blog.model.CommenttLikesModel;
import com.blog.restapi_blog.model.PostModel;
import com.blog.restapi_blog.model.UserModel;
import com.blog.restapi_blog.repository.CommentLikesRepository;
import com.blog.restapi_blog.repository.CommentsRepository;
import com.blog.restapi_blog.repository.PostRepository;
import com.blog.restapi_blog.repository.UserRepository;
import com.blog.restapi_blog.services.CommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentLikeServiceImpl implements CommentLikeService {
    @Autowired
    CommentLikesRepository commentLikesRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentsRepository commentsRepository;

    @Override
    public void saveLikeByUserForaPost(int comId, int userId,int postId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("user does not exit"));
        PostModel post = postRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("post does not exit"));
        Comments comments = commentsRepository.findById(comId)
                .orElseThrow(()->new ResourceNotFoundException("comments does not exit"));
        CommenttLikesModel like =CommenttLikesModel.builder()
                .post(post)
                .comments(comments)
                .user(user)
                .build();
        commentLikesRepository.save(like);
    }


}
