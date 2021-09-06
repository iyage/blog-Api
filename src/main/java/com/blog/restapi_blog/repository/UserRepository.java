package com.blog.restapi_blog.repository;

import com.blog.restapi_blog.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Integer> {
    Optional<UserModel> findByUsernameAndPassword(String username,String password);
}
