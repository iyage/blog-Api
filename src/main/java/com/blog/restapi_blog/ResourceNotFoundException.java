package com.blog.restapi_blog;

public class ResourceNotFoundException extends RuntimeException{
    private   String message;

    public ResourceNotFoundException(String message) {
        this.message = message;
    }
}
