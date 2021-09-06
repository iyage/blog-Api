package com.blog.restapi_blog.services.serviceimpl;

import com.blog.restapi_blog.ResourceNotFoundException;
import com.blog.restapi_blog.model.Comments;
import com.blog.restapi_blog.model.PostModel;
import com.blog.restapi_blog.model.UserModel;
import com.blog.restapi_blog.repository.CommentsRepository;
import com.blog.restapi_blog.repository.PostRepository;
import com.blog.restapi_blog.repository.UserRepository;
import com.blog.restapi_blog.services.CommentsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Comments makeCommments(Comments comments) {

        return  commentsRepository.save(comments);
    }

    @Override
    public Comments editComment(int userId, int postId,String content) {
        PostModel post = postRepository.findById(postId).get();
        UserModel user = userRepository.findById(userId).get();
        Comments comments = Comments.builder()
                .user(user)
                .content(content)
                .post(post)
                .build();
        return  commentsRepository.save(comments);
    }

    @Override
    public List<Comments> findAllUserComments(int userId) throws ResourceNotFoundException {
        return commentsRepository.findAllByUserId(userId);
    }

    @Override
    public List<Comments> findAllpostComments(int postId) throws ResourceNotFoundException {
        return commentsRepository.findAllByPostId(postId);
    }

    @Override
    public Comments findUserCommentOnAPost (int postId, int userId) throws  ResourceNotFoundException{
        return commentsRepository.findByUserIdAndPostId(userId,postId);
    }

    @Override
    public Comments deleteComment(int id) throws ResourceNotFoundException {
        Comments comments = commentsRepository.findById(id).get();
        commentsRepository.delete(comments);
        return comments;
    }
}
