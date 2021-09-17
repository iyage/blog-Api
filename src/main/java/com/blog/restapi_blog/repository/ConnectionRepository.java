package com.blog.restapi_blog.repository;

import com.blog.restapi_blog.model.ConnectionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConnectionRepository extends JpaRepository<ConnectionModel,Integer> {
    Optional<ConnectionModel> findConnectionModelByConnetionIdAndUserId(int userId, int connectionId);
    List<ConnectionModel> findConnectionModelByUserId(int id);
}
