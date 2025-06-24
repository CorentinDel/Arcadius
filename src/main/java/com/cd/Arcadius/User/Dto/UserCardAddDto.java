package com.cd.Arcadius.User.Dto;

import jakarta.validation.constraints.NotEmpty;

public record UserCardAddDto(@NotEmpty Long userId, @NotEmpty Long cardId) {

}
