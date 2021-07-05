package com.example.reddit.repository;

import com.example.reddit.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.DoubleStream;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);

    List<Comment> findAllByUser(User user);

    List<Comment> findByPost(Post post);
}
