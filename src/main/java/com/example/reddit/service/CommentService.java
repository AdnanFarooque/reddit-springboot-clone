package com.example.reddit.service;

import com.example.reddit.dto.CommentRequest;
import com.example.reddit.dto.CommentResponse;
import com.example.reddit.exceptions.PostNotFoundException;
import com.example.reddit.exceptions.UserNotFoundException;
import com.example.reddit.mapper.CommentMapper;
import com.example.reddit.model.*;
import com.example.reddit.repository.CommentRepository;
import com.example.reddit.repository.PostRepository;
import com.example.reddit.repository.SubredditRepository;
import com.example.reddit.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class CommentService {

    private static final String POST_URL = "";
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final AuthService authService;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;
    private final UserRepository userRepository;

    @Transactional
    public CommentResponse save(CommentRequest commentRequest) {
        User currentUser = authService.getCurrentUser();
        Post post = postRepository.findByPostName(commentRequest.getPostName())
                .orElseThrow(() -> new PostNotFoundException(commentRequest.getPostName()));
        Comment save = commentRepository.save(commentMapper.mapDtoToComment(commentRequest, post, currentUser));

        String message = mailContentBuilder.build(post.getUser().getUsername() +
                " posted a comment on your post " + POST_URL);
        sendCommentNotification(message, post.getUser());

        return commentMapper.mapCommentToDto(save);
    }

    private void sendCommentNotification(String message, User user) {
        mailService.sendEmail(new NotificationEmail
                (user.getUsername() + " commented on your post",
                        user.getEmail(), message));
    }

    public List<CommentResponse> getCommentsByPostId(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
        List<Comment> comments = commentRepository.findAllByPost(post);
        return comments.stream().map(commentMapper::mapCommentToDto).collect(toList());
    }

    public List<CommentResponse> getCommentsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        List<Comment> comments = commentRepository.findAllByUser(user);
        return comments.stream().map(commentMapper::mapCommentToDto).collect(toList());
    }
}
