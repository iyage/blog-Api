package com.blog.restapi_blog.services;

import com.blog.restapi_blog.model.Comments;

import java.util.List;

public interface CommentsService {
    Comments makeCommments(Comments comments);
    Comments editComment(int userId, int postId,String content);
    List<Comments>findAllUserComments(int userId);
    List<Comments>findAllpostComments(int postId);
    Comments findUserCommentOnAPost(int postId,int userId);
    Comments deleteComment(int id);



}
