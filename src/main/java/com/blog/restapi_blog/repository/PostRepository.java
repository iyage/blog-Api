package com.blog.restapi_blog.repository;

import com.blog.restapi_blog.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostModel, Integer> {
    List<PostModel> findPostModelsByIdAndAndUserId(int userId, int postId);
}
