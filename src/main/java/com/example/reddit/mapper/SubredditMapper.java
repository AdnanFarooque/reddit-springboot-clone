package com.example.reddit.mapper;

//import jdk.internal.loader.*;

import com.example.reddit.dto.SubredditDto;
import com.example.reddit.model.Post;
import com.example.reddit.model.Subreddit;
import com.example.reddit.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubredditMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts()))")
    @Mapping(target = "username", source = "user.username")
    SubredditDto mapSubredditToDto(Subreddit subreddit);

    default Long mapPosts(List<Post> numberOfPosts) {
        if(numberOfPosts == null) {
            return 0L;
        }
        return (long) numberOfPosts.size();
    }


    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "user", source = "currentUser")
    @Mapping(target = "posts", ignore = true)
    Subreddit mapDtoToSubreddit(SubredditDto subredditDto, User currentUser);
}
