package com.blog.restapi_blog.restcontroller;

import com.blog.restapi_blog.exceptions.ResourceNotFoundException;
import com.blog.restapi_blog.model.PostModel;
import com.blog.restapi_blog.model.dto.UserPostDto;
import com.blog.restapi_blog.services.serviceimpl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostServiceImpl postService;
   @GetMapping("/show_all_post")
     public ResponseEntity<Object>showAllPost(){
       List<PostModel> allPost = postService.findAllPost();
       return  new ResponseEntity<Object>(allPost, HttpStatus.OK);
   }
   @GetMapping("/show_post/{id}")
   public ResponseEntity<Object>showPost(@PathVariable(value = "id")int id){
       PostModel post = postService.findPostById(id);
       return  new ResponseEntity<Object>(post, HttpStatus.OK);
   }
//   @PostMapping("/show_user_post")
//   public ResponseEntity<Object>showPost(@RequestBody UserPostDto userPostDto){
//           List<PostModel> post = postService.findByPostByIDAndUserID(userPostDto.getUserId(),userPostDto.getPostId());
//           return  new ResponseEntity<Object>(post, HttpStatus.OK);
//   }
}
