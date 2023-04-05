package com.tweetero.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetero.api.models.User;
import com.tweetero.api.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public User findByUsername(String username){
    return repository.findByUsername(username);
  }
  
  public void create(User data){
    repository.save(data);
  }
}
