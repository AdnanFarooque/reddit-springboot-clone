//package com.example.reddit.service;
//
//import com.example.reddit.dto.CommentRequest;
//import com.example.reddit.dto.CommentResponse;
//import com.example.reddit.dto.PostRequest;
//import com.example.reddit.dto.PostResponse;
//import com.example.reddit.exceptions.SubredditNotFoundException;
//import com.example.reddit.model.Post;
//import com.example.reddit.model.Subreddit;
//import com.example.reddit.model.User;
//import org.springframework.transaction.annotation.Transactional;
//
//public class CommentService {
//
//    @Transactional
//    public CommentResponse save(CommentRequest commentRequest) {
//        Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
//                .orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));
//        User currentUser = authService.getCurrentUser();
//        Post save = postRepository.save(postMapper.mapDtoToPost(postRequest, subreddit, currentUser));
//        PostResponse postResponse = new PostResponse();
//        postResponse.setId(save.getPostId());
//        postResponse.setPostName(save.getPostName());
//        postResponse.setUrl(save.getUrl());
//        postResponse.setDescription(save.getDescription());
//        postResponse.setUserName(save.getUser().getUsername());
//        postResponse.setSubredditName(save.getSubreddit().getName());
//        postResponse.setCreatedDate(save.getCreatedDate().toString());
//        postResponse.setVoteCount(save.getVoteCount());
//        return postResponse;
//    }
//}
