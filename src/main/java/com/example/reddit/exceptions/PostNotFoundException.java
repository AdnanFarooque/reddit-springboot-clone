package com.example.reddit.exceptions;

public class PostNotFoundException extends SpringRedditException{

    public PostNotFoundException(Long postId) {
        super("Post with id - " + postId + " was not found");
    }

    public PostNotFoundException(String postName) {
        super("Post with name - " + postName + " was not found");
    }
}
