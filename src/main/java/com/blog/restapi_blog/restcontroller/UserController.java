package com.blog.restapi_blog.restcontroller;

import com.blog.restapi_blog.model.*;
import com.blog.restapi_blog.model.dto.ConnectionDto;
import com.blog.restapi_blog.model.dto.PostDto;
import com.blog.restapi_blog.model.dto.UserPostDto;
import com.blog.restapi_blog.model.dto.UserDto;
import com.blog.restapi_blog.services.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @PostMapping("/register")
    public ResponseEntity<UserModel> registerUser(@Valid @RequestBody UserModel userModel){
       UserModel user = userService.registerUser(userModel);
        System.out.println(user);
   return new ResponseEntity<UserModel>(user,HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<Object>login(@RequestBody UserDto userDto){
          UserModel userModel = userService.Userlogin(userDto.getUsername(),userDto.getPassword());
           return  new ResponseEntity<Object>(userModel,HttpStatus.OK);
    }
    @PostMapping("/create_post")
    public ResponseEntity<Object>createPost(@RequestBody PostDto post){
       PostModel postModel = userService.savePost(post.getContent(),post.getUserId());
      return new ResponseEntity<Object>(postModel,HttpStatus.CREATED);
    }
    @GetMapping("/delete_post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id){
        userService.deletePost(id);
   return new ResponseEntity<String>("deleted",HttpStatus.OK);
    }
    @PostMapping("/postLike_dislike")
    public ResponseEntity<Object> postlisk_dislike(@RequestBody UserPostDto postlikeDto){
        Long count = userService.userLikeAPost( postlikeDto.getUserId(),postlikeDto.getPostId());
        return new ResponseEntity<Object>(count,HttpStatus.OK);
    }
    @PostMapping("/add_connection")
    public ResponseEntity<Object>addConnection(@RequestBody ConnectionDto connectionDto){
        userService.addConnection(connectionDto.getUserId(),connectionDto.getConnectionId());
   return  new ResponseEntity<Object>(HttpStatus.OK);
    }
    @GetMapping("/show_all_user_Connection/{id}")
    public  ResponseEntity<List<ConnectionModel>>showAllUserConnection(@PathVariable int id){
      List<ConnectionModel>listOfConnection =  userService.showAllUserConnections(id);
      return  new ResponseEntity<List<ConnectionModel>>(listOfConnection,HttpStatus.OK);

    }
}
