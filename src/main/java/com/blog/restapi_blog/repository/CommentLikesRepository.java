package com.blog.restapi_blog.repository;

import com.blog.restapi_blog.model.CommenttLikesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikesRepository extends JpaRepository<CommenttLikesModel,Integer> {
}
