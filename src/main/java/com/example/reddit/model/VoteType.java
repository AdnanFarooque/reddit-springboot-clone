package com.example.reddit.model;

import com.example.reddit.exceptions.SpringRedditException;
import java.util.Arrays;

public enum VoteType {
    UPVOTE(1L), DOWNVOTE(-1L);

    private static long direction;


    VoteType(Long direction) {
    }

    public static VoteType lookup(Long direction) {
        return Arrays.stream(VoteType.values())
                .filter(value -> value.getDirection().equals(direction))
                .findAny()
                .orElseThrow(() -> new SpringRedditException("Vote not found"));
    }

    public Long getDirection(){
        return direction;
    }
 }
