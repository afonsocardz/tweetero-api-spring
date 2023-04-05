package com.tweetero.api.models;

import com.tweetero.api.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tweets")
@NoArgsConstructor
public class Tweet extends User{

  public Tweet(TweetDTO req){
    super.setAvatar(req.avatar());
    super.setUsername(req.username());
    this.tweet = req.tweet();
  }
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column(nullable = false)
  private String tweet;

}
