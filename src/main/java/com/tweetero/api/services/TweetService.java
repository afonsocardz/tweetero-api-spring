package com.tweetero.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.tweetero.api.models.Tweet;
import com.tweetero.api.repositories.TweetRepository;

@Service
public class TweetService {
  
  @Autowired
  private TweetRepository repository;

  public List<Tweet> findAll() {
    return repository.findAll();
  }

  public List<Tweet> findTweetsByUsername(String username) {
    return repository.findTweetsByUsername(username);
  }

  public void create(Tweet data) {
    repository.save(data);
  }
}
