package com.blog.restapi_blog.services;

import com.blog.restapi_blog.model.PostModel;

import java.util.List;

public interface Postservice {
    List<PostModel>findAllPost();
   PostModel findPostById(int id);
//   List<PostModel>findByPostByIDAndUserID(int userid,int postid);
}
