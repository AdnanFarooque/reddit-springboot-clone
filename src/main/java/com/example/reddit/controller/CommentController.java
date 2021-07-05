package com.example.reddit.controller;

import com.example.reddit.dto.CommentRequest;
import com.example.reddit.dto.CommentResponse;
import com.example.reddit.dto.PostResponse;
import com.example.reddit.service.CommentService;
import com.example.reddit.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/comments/")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/")
    public ResponseEntity<CommentResponse> createComment(@RequestBody CommentRequest commentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commentService.save(commentRequest));
    }

    @GetMapping("/by-postId/{postId}")
    public ResponseEntity<List<CommentResponse>> getPost(@PathVariable Long postId) {
        return status(HttpStatus.OK).body(commentService.getCommentsByPostId(postId));
    }

    @GetMapping("/by-user/{username}")
    public ResponseEntity<List<CommentResponse>> getPost(@PathVariable String username) {
        return status(HttpStatus.OK).body(commentService.getCommentsByUsername(username));
    }
}
