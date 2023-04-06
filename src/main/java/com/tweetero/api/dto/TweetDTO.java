package com.tweetero.api.dto;

import jakarta.validation.constraints.NotNull;

public record TweetDTO(
    @NotNull String text) {
}
