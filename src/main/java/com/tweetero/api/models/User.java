package com.tweetero.api.models;

import org.springframework.data.annotation.Id;

import com.tweetero.api.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User {

  public User(UserDTO req) {
    this.username = req.username();
    this.avatar = req.avatar();
  }

  @Id
  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String avatar;
}
