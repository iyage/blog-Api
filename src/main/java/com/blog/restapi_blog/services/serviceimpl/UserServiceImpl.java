package com.blog.restapi_blog.services.serviceimpl;

import com.blog.restapi_blog.exceptions.InvalidUserNameAndPasswordException;
import com.blog.restapi_blog.exceptions.ResourceNotFoundException;
import com.blog.restapi_blog.model.ConnectionModel;
import com.blog.restapi_blog.model.PostLikesModel;
import com.blog.restapi_blog.model.PostModel;
import com.blog.restapi_blog.model.UserModel;
import com.blog.restapi_blog.repository.ConnectionRepository;
import com.blog.restapi_blog.repository.PostRepository;
import com.blog.restapi_blog.repository.UserRepository;
import com.blog.restapi_blog.repository.PostLikesRepository;
import com.blog.restapi_blog.services.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class UserServiceImpl implements UserService {
    @Autowired
    ConnectionRepository connectionRepository;
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
     UserModel user = userRepository.findByUsernameAndPassword(username,password).orElseThrow(()->
             new InvalidUserNameAndPasswordException("Invalid password or username"));
        return user;
    }

    @Override
    public PostModel savePost(String content,int userId) {
        UserModel userModel = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User with id:"
                        +userId+"does not exit") );
        PostModel post = new PostModel();
        post.setContent(content);
        System.out.println(post.getContent());
        post.setUser(userModel);
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Integer id) throws ResourceNotFoundException {
        postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("post with id:"+id+
                "does not exit"));
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
       postLikesRepository.save(postLikesModel);
          return  postLikesRepository.count();
       }

    }

    @Override
    public void addConnection(int userId, int connectionId) {
     Optional<ConnectionModel>optional = connectionRepository
                .findConnectionModelByConnetionIdAndUserId(connectionId,userId);
     if(optional.isPresent()){
         throw  new ResourceNotFoundException("user connection exit already");
     }else {
         UserModel user = userRepository.findById(userId)
                 .orElseThrow(() -> new ResourceNotFoundException("User does not exit"));
         UserModel connection = userRepository.findById(connectionId)
                 .orElseThrow(() -> new ResourceNotFoundException("connection does not exit"));
         ConnectionModel connectionModel = ConnectionModel.builder()
                 .connetion(connection)
                 .user(user)
                 .build();
         connectionRepository.save(connectionModel);
     }

    }

    @Override
    public List  showAllUserConnections(int id) {
        List<List<PostModel>>postList = new ArrayList<>();
        List<ConnectionModel> connectionList= connectionRepository.findConnectionModelByUserId(id);
        for (ConnectionModel connection:connectionList) {
        int connectionId =  connection.getConnetion().getId();
             List<PostModel> post = postRepository.findPostModelsByUserId(connectionId);
           postList.add(post);
        }

   return  postList;
    }

}
