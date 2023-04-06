package com.tweetero.api.dto;

public record TweetWithUserDTO(
    String username,
    String avatar,
    String text) {
}
