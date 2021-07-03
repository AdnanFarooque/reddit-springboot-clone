//package com.example.reddit.controller;
//
//import com.example.reddit.dto.CommentResponse;
//import com.example.reddit.service.CommentService;
//import com.example.reddit.service.PostService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/comments/")
//@AllArgsConstructor
//public class CommentController {
//    private CommentService commentService;
//
//    @PostMapping("/")
//    public ResponseEntity<CommentResponse> createComment(@RequestBody CommentRequest commentRequest) {
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(commentService.save(commentRequest));
//    }
//}
