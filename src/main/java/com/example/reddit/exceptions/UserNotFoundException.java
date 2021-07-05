package com.example.reddit.exceptions;

public class UserNotFoundException extends SpringRedditException {
    public UserNotFoundException(String username) {
        super("User with name " + username + " was not found");
    }
}
