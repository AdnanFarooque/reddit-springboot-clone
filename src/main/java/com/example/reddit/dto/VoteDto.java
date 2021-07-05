package com.example.reddit.dto;

import com.example.reddit.model.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteDto {
    private Long voteId;
    private VoteType voteType;
    private Long postId;
    private String username;
}
