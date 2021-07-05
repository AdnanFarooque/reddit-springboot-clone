package com.example.reddit.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long postId;
    private String postName;
    private String url;
    private String description;
    private String username;
    private String subredditName;
    private String createdDate;
    private Long voteCount;
    private Long commentCount;
    private String duration;
}
