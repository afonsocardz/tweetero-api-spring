package com.tweetero.api.dto;

import jakarta.validation.constraints.NotNull;

public record TweetDTO(
    @NotNull String username,
    @NotNull String avatar,
    @NotNull String tweet) {
}
