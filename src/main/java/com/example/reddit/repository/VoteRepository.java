package com.example.reddit.repository;

import com.example.reddit.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
