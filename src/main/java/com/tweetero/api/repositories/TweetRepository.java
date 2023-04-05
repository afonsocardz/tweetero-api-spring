package com.tweetero.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetero.api.models.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
  List<Tweet> findTweetsByUsername(String username);
}
