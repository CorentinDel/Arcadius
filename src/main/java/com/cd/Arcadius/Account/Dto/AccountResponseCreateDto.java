package com.cd.Arcadius.Account.Dto;

import java.util.Date;

import com.cd.Arcadius.User.Dto.UserResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountResponseCreateDto(
                String email,
                @JsonProperty("created_at") Date createdAt,
                UserResponseDto user) {
}
