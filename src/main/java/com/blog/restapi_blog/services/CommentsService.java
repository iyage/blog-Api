package com.blog.restapi_blog.services;

import com.blog.restapi_blog.model.Comments;

import java.util.List;

public interface CommentsService {
    Comments makeCommments(int userId,int postId, String content);
    Comments editComment(int id,String content);
    List<Comments>findAllUserComments(int userId);
    List<Comments>findAllpostComments(int postId);
    List<Comments> findUserCommentOnAPost(int postId,int userId);
    Comments deleteComment(int id);



}
