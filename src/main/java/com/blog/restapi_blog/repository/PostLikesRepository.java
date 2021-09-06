package com.blog.restapi_blog.repository;

import com.blog.restapi_blog.model.PostLikesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikesRepository extends JpaRepository<PostLikesModel, Integer > {
   Optional<PostLikesModel> findAllByUserIdAndPsstId(int userId, int postId);

}
