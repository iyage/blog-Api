package com.blog.restapi_blog.services.serviceimpl;

import com.blog.restapi_blog.exceptions.ResourceNotFoundException;
import com.blog.restapi_blog.model.PostModel;
import com.blog.restapi_blog.repository.PostRepository;
import com.blog.restapi_blog.services.Postservice;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@NoArgsConstructor
public class PostServiceImpl implements Postservice {
    @Autowired
  PostRepository postRepository;
    @Override
    public List<PostModel> findAllPost() {
        return postRepository.findAll() ;
    }

    @Override
    public PostModel findPostById(int id)  {
return postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post with id:" +id +"  does not exit"));

    }
//
//    @Override
//    public List<PostModel> findByPostByIDAndUserID (int userid, int postid) throws ResourceNotFoundException {
//  return postRepository.findPostModelsByIdAndAndUserId(userid,postid);
//      }
}
