package com.example.reddit.exceptions;

public class PostNotFoundException extends SpringRedditException{

    public PostNotFoundException(Long postId) {
        super("Post with id - " + postId + " was not found");
    }

}
