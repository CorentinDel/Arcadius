package com.cd.Arcadius.Account.Dto;

import com.cd.Arcadius.User.Dto.UserResponseDto;

public record AccountResponseAuthenticationDto(
        String accessToken,
        String refreshToken,
        String email,
        UserResponseDto user) {
}
