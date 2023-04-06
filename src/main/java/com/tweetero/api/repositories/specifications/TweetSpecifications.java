package com.tweetero.api.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.tweetero.api.models.Tweet;
import com.tweetero.api.models.User;

import jakarta.persistence.criteria.Join;

public class TweetSpecifications {
  public static Specification<Tweet> hasUserWithUsername(String username) {
    return (root, query, criteriaBuilder) -> {
      Join<User, Tweet> userTweets = root.join("user");
      return criteriaBuilder.equal(userTweets.get("username"), username);
    };
  }
}
