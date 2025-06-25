package com.cd.Arcadius.UserCard.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserCardDto(@JsonProperty("user_id") Long userId, @JsonProperty("card_id") Long cardId, int count) {

}
