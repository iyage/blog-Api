package com.blog.restapi_blog.services;

import com.blog.restapi_blog.model.PostLikesModel;
import com.blog.restapi_blog.model.PostModel;
import com.blog.restapi_blog.model.UserModel;

public interface UserService {
  UserModel registerUser(UserModel user);
  UserModel Userlogin(String username, String password);
  PostModel savePost(PostModel post);
  void  deletePost(Integer id);
Long  userLikeAPost(int userId, int postId);
}
