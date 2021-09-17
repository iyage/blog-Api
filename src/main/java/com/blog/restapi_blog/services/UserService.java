package com.blog.restapi_blog.services;

import com.blog.restapi_blog.model.ConnectionModel;
import com.blog.restapi_blog.model.PostLikesModel;
import com.blog.restapi_blog.model.PostModel;
import com.blog.restapi_blog.model.UserModel;

import java.util.List;

public interface UserService {
  UserModel registerUser(UserModel user);
  UserModel Userlogin(String username, String password);
  PostModel savePost(String content,int userId);
  void  deletePost(Integer id);
Long  userLikeAPost(int userId, int postId);
void addConnection(int userId, int connectionId);
List showAllUserConnections(int id);
}
