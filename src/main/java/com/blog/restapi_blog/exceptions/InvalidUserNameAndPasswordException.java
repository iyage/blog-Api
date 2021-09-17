package com.blog.restapi_blog.exceptions;

public class InvalidUserNameAndPasswordException extends RuntimeException{
    public InvalidUserNameAndPasswordException(String message) {
        super(message);
    }
}
