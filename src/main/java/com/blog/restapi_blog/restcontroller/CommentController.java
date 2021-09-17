package com.blog.restapi_blog.restcontroller;

import com.blog.restapi_blog.model.Comments;
import com.blog.restapi_blog.model.dto.CommentDto;
import com.blog.restapi_blog.model.dto.EditCommentDto;
import com.blog.restapi_blog.model.dto.UserPostDto;
import com.blog.restapi_blog.services.serviceimpl.CommentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentsServiceImpl commentsService;
    @PostMapping("/post_comment")
    public ResponseEntity<Object> postComment(@RequestBody CommentDto commentDto){
        Comments comments = commentsService.makeCommments(commentDto.getUserId(),commentDto.getPostId(),commentDto.getContent());
        return new ResponseEntity<Object>(comments, HttpStatus.OK);
    }
    @GetMapping("/show_user_comment/{id}")
    public ResponseEntity<Object> showUserComments(@PathVariable(value = "id") int id){
        List<Comments>commentsList = commentsService.findAllUserComments(id);
        return new ResponseEntity<Object>(commentsList, HttpStatus.OK);
    }
    @GetMapping("/show_post_comment/{id}")
    public ResponseEntity<Object> showPostComments(@PathVariable(value = "id") int id){
        List<Comments>commentsList = commentsService.findAllpostComments(id);
        return new ResponseEntity<Object>(commentsList, HttpStatus.OK);
    }
    @PostMapping("/show_all_post_commment_by_user")
    public ResponseEntity<Object> showCommnets(@RequestBody UserPostDto userPostDto){
        List<Comments> comments = commentsService.findUserCommentOnAPost(userPostDto.getPostId(),userPostDto.getUserId());
        return new ResponseEntity<Object>(comments, HttpStatus.OK);
    }

@GetMapping("/delete_comment/{id}")
    public  ResponseEntity<Object>deleteComment(@PathVariable( value = "id")int id){
        commentsService.deleteComment(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    @PostMapping("/edit_comment")
    public  ResponseEntity<Object>editComment(@RequestBody EditCommentDto com){
    commentsService.editComment(com.getId(), com.getContent());
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
