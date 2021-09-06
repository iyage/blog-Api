package com.blog.restapi_blog.services.serviceimpl;

import com.blog.restapi_blog.model.PostLikesModel;
import com.blog.restapi_blog.model.PostModel;
import com.blog.restapi_blog.model.UserModel;
import com.blog.restapi_blog.repository.PostRepository;
import com.blog.restapi_blog.repository.UserRepository;
import com.blog.restapi_blog.repository.PostLikesRepository;
import com.blog.restapi_blog.services.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class UserServiceImpl implements UserService {
    @Autowired
    private PostLikesRepository postLikesRepository;
    @Autowired
   private PostRepository postRepository;
    @Autowired
   private UserRepository userRepository;
    @Override
    public UserModel registerUser(UserModel user) {
        return userRepository.save(user);

    }

    @Override
    public UserModel Userlogin(String username, String password) {
        Optional<UserModel> user = userRepository.findByUsernameAndPassword(username,password);
        return user.get();
    }

    @Override
    public PostModel savePost(PostModel post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    public Long  userLikeAPost(int userId, int postId) {
       Optional<PostLikesModel> postLike = postLikesRepository.findAllByUserIdAndPsstId(userId,postId);
       if(postLike.isPresent()){
           postLikesRepository.delete(postLike.get());
          return  postLikesRepository.count();
       }
       else{
      PostModel post = postRepository.findById(postId).get();
      UserModel user = userRepository.findById(userId).get();
      PostLikesModel postLikesModel = PostLikesModel.builder()
              .psst(post)
              .user(user)
              .build();
          return  postLikesRepository.count();
       }

    }
}
