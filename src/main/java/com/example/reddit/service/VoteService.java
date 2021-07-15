package com.example.reddit.service;

import com.example.reddit.dto.VoteDto;
import com.example.reddit.exceptions.PostNotFoundException;
import com.example.reddit.exceptions.SpringRedditException;
import com.example.reddit.model.Post;
import com.example.reddit.model.Vote;
import com.example.reddit.repository.PostRepository;
import com.example.reddit.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.reddit.model.VoteType.DOWNVOTE;
import static com.example.reddit.model.VoteType.UPVOTE;

@Service
@AllArgsConstructor
public class VoteService {
    private final PostRepository postRepository;
    private final VoteRepository voteRepository;
    private final AuthService authService;

    @Transactional
    public void vote(VoteDto voteDto) {
        Post post = postRepository.findByPostId(voteDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException(voteDto.getPostId()));
        Optional<Vote> voteByPostAndUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post, authService.getCurrentUser());
        if(voteByPostAndUser.isPresent() &&
                voteByPostAndUser.get().getVoteType().equals(voteDto.getVoteType()) && post.getVoteCount() != 0) {
            throw new SpringRedditException("You have already voted " + voteDto.getVoteType() + " for this post");
        }
        if(UPVOTE.equals(voteDto.getVoteType())) {
            post.setVoteCount(post.getVoteCount() + 1);
        } else if(DOWNVOTE.equals(voteDto.getVoteType())){
            post.setVoteCount(post.getVoteCount() - 1);
        }
        voteRepository.save(mapToVote(voteDto, post));
        postRepository.save(post);
    }

    private Vote mapToVote(VoteDto voteDto, Post post) {
        return Vote.builder()
                .voteType(voteDto.getVoteType())
                .post(post)
                .user(authService.getCurrentUser())
                .build();
    }
}
