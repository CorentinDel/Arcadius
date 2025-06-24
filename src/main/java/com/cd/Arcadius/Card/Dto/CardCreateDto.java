package com.cd.Arcadius.Card.Dto;

import com.cd.Arcadius.Card.Enum.CardRarityEnum;
import com.cd.Arcadius.Card.Enum.CardTypeEnum;

import jakarta.validation.constraints.NotEmpty;

public record CardCreateDto(@NotEmpty String name, @NotEmpty String filename,
                @NotEmpty CardTypeEnum type, @NotEmpty CardRarityEnum rarity) {
}
