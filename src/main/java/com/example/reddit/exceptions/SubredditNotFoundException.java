package com.example.reddit.exceptions;

public class SubredditNotFoundException extends SpringRedditException {

    public SubredditNotFoundException(String subredditName) {
        super("Subreddit " + subredditName  + " not found.");
    }

    public SubredditNotFoundException(Long subredditId) {
        super("Subreddit with id - " + subredditId  + " not found.");
    }

}
