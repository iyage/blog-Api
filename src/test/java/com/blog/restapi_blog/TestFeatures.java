package com.blog.restapi_blog;

import com.blog.restapi_blog.model.Comments;
import com.blog.restapi_blog.model.PostLikesModel;
import com.blog.restapi_blog.model.PostModel;
import com.blog.restapi_blog.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class TestFeatures {
    public static UserModel user1 = UserModel.builder()
            .id(1)
            .firstName("yage")
            .lastName("Ofunrein")
            .email("yag.@gmail.com")
            .username("yage")
            .password("1234")
            .build();
    public static UserModel user2 = UserModel.builder()
            .id(1)
            .firstName("bunmi")
            .lastName("Ofunrein")
            .email("bunmi.@gmail.com")
            .username("bunmi")
            .password("1234")
            .build();

    public  static List<UserModel>users = new ArrayList<>();
    public  static List<PostModel>posts = new ArrayList<>();
    public static UserModel registerNewUser(UserModel user){
        users.add(user);
    return user;
    }
    public static PostModel saveNewPostr(String content,UserModel user){
        PostModel post = PostModel.builder()
                .id(4)
                .user(user)
                .content(content)
                        .build();
posts.add(post);
        return post;
    }
    public  static PostModel post1 = PostModel.builder()
            .id(1)
            .content("The world is coming to an end very soon")
            .build();
    public  static PostModel post2 = PostModel.builder()
            .id(2)
            .content("Give love to get love back")
            .build();
    public  static  PostLikesModel postlike = PostLikesModel.builder()
            .id(1)
            .psst(post1)
            .user(user1)
            .build();
    public  static  PostLikesModel postlike1 = PostLikesModel.builder()
            .id(1)
            .psst(post1)
            .user(user1)
            .build();
   public static List<PostLikesModel> postLikesModelList = new ArrayList<>();
    public  static PostLikesModel likeadded(PostLikesModel postlikes) {
        postLikesModelList.add(postlikes);
        return postlikes;
    }
    public  static  PostLikesModel findPostLikes(int userId,int postId){
        for (PostLikesModel postlikes:postLikesModelList) {
            if(postlikes.getPsst().getId()==postId && postlikes.getUser().getId()==userId){
                return postlikes;
            }
        }

    return  null;
    }
    public  static List<Comments>commentsList = new ArrayList<>();
    public  static Comments comment1 = Comments.builder()
            .id(1)
            .content("i love this post")
            .user(user1)
            .post(post1)
            .build();

    public static Comments saveNewComment(String content,PostModel postModel,UserModel userModel){
       Comments newComment = Comments.builder()
                .id(2)
                .user(userModel)
                .content(content)
               .post(postModel)
                .build();
     commentsList.add(newComment);
        return newComment;
    }





}
