package com.tweetero.api.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.tweetero.api.models.Tweet;
import com.tweetero.api.dto.TweetWithUserDTO;
import com.tweetero.api.repositories.TweetRepository;
import com.tweetero.api.repositories.specifications.TweetSpecifications;

@Service
public class TweetService {

  @Autowired
  private TweetRepository repository;

  public Page<TweetWithUserDTO> findAll(int page) {
    int pageSize = 5;
    Pageable tweetsPage = PageRequest.of(page, pageSize, Sort.by("id").descending());
    Page<Tweet> tweets = repository.findAll(tweetsPage);

    return tweets.map(new Function<Tweet, TweetWithUserDTO>() {
      @Override
      public TweetWithUserDTO apply(Tweet tweet) {
        return new TweetWithUserDTO(tweet.getUser().getUsername(), tweet.getUser().getAvatar(),
            tweet.getText());
      }
    });
  }

  public List<Tweet> findTweetsByUsername(String username) {
    Specification<Tweet> specification = TweetSpecifications.hasUserWithUsername(username);
    return repository.findAll(specification);
  }

  public void create(Tweet data) {
    repository.save(data);
  }
}
