package com.blog.restapi_blog.model.dto;

import lombok.Data;

@Data
public class CommentDto {
int postId;
int userId;
String content;

}
