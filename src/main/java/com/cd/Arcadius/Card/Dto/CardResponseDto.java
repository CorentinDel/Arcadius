package com.cd.Arcadius.Card.Dto;

import com.cd.Arcadius.Card.Enum.CardRarityEnum;
import com.cd.Arcadius.Card.Enum.CardTypeEnum;

public record CardResponseDto(Long id, String name, String filename, CardTypeEnum type,
        CardRarityEnum rarity) {
}
