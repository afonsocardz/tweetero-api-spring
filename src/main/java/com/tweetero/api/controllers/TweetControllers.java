package com.tweetero.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dto.TweetDTO;
import com.tweetero.api.models.Tweet;
import com.tweetero.api.services.TweetService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tweets")
public class TweetControllers {
  @Autowired
  private TweetService service;

  @GetMapping
  public List<Tweet> findAll() {
    return service.findAll();
  }

  @GetMapping("/{username}")
  public List<Tweet> findTweetsByUsername(@PathVariable String username) {
    return service.findTweetsByUsername(username);
  }

  @PostMapping
  public void create(TweetDTO reqTweetDTO) {
    service.create(new Tweet(reqTweetDTO));
  }
}
