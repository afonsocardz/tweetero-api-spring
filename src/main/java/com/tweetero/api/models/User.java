package com.tweetero.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tweetero.api.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "tweets"})
public class User {

  public User(UserDTO req) {
    this.username = req.username();
    this.avatar = req.avatar();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String avatar;

  @OneToMany(mappedBy = "user")
  private List<Tweet> tweets;
}
