package com.tweetero.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dto.TweetDTO;
import com.tweetero.api.dto.TweetWithUserDTO;
import com.tweetero.api.models.Tweet;
import com.tweetero.api.models.User;
import com.tweetero.api.services.TweetService;
import com.tweetero.api.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tweets")
public class TweetControllers {

  @Autowired
  private TweetService service;

  @Autowired
  private UserService userService;

  @GetMapping
  public Page<TweetWithUserDTO> findAll(@RequestParam int page) {
    return service.findAll(page);
  }

  @GetMapping("/{username}")
  public List<Tweet> findTweetsByUsername(@PathVariable String username) {
    return service.findTweetsByUsername(username);
  }

  @PostMapping
  @ResponseStatus(value = HttpStatus.CREATED)
  public void create(@RequestHeader("User") String User, @RequestBody TweetDTO reqTweetDTO) {
    User user = userService.findByUsername(User);
    Tweet tweet = new Tweet(reqTweetDTO, user);
    service.create(tweet);
  }
}
