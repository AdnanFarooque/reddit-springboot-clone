package com.example.reddit.exceptions;

public class PostNotFoundException extends SpringRedditException{

    public PostNotFoundException(String postId) {
        super("Post with id - " + postId + " was not found");
    }
}
