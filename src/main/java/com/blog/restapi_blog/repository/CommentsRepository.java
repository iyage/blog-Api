package com.blog.restapi_blog.repository;

import com.blog.restapi_blog.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments,Integer> {
List<Comments> findAllByUserId(int userId);
    List<Comments> findAllByPostId(int postId);
    Comments findByUserIdAndPostId(int userId,int postId);
}
