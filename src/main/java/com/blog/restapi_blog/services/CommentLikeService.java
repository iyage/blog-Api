package com.blog.restapi_blog.services;

public interface CommentLikeService {
    void saveLikeByUserForaPost(int comId,int userId,int postId);
}
