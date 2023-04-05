package com.tweetero.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dto.UserDTO;
import com.tweetero.api.models.User;
import com.tweetero.api.services.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class UserControllers {

  @Autowired
  private UserService service;

  @PostMapping("/sign-up")
  @ResponseStatus(value = HttpStatus.CREATED)
  public void signUp(@RequestBody @Valid UserDTO reqUserDTO){
    service.create(new User(reqUserDTO));
  }
}
