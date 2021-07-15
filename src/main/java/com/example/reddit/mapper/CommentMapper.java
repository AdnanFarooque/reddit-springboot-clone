package com.example.reddit.mapper;

import com.example.reddit.dto.CommentRequest;
import com.example.reddit.dto.CommentResponse;
import com.example.reddit.model.Comment;
import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "commentId", ignore = true)
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "user", source = "currentUser")
    @Mapping(target = "post", source = "post")
    Comment mapDtoToComment(CommentRequest commentRequest, Post post, User currentUser);

    @Mapping(target = "postId", source = "comment.post.postId")
    @Mapping(target = "username", source = "comment.user.username")
    CommentResponse mapCommentToDto(Comment comment);
}
