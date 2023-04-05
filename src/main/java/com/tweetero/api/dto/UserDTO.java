package com.tweetero.api.dto;

import jakarta.validation.constraints.NotNull;

public record UserDTO(
    @NotNull String username,
    @NotNull String avatar) {
}