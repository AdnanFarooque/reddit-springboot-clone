package com.example.reddit.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubredditDto {
    private Long subredditId;
    private String name;
    private String description;
    private String username;
    private String createdDate;
    private Long numberOfPosts;
}
