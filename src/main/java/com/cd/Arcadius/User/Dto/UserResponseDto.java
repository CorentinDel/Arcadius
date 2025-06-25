package com.cd.Arcadius.User.Dto;

import com.cd.Arcadius.Pack.PackDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UserResponseDto(Long id, String username, Integer level, @JsonProperty("level_xp") Integer levelXp,
                @JsonProperty("total_xp") Long totalXp, PackDto pack) {
}
