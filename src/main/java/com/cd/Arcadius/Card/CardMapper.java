package com.cd.Arcadius.Card;

import org.springframework.stereotype.Service;

import com.cd.Arcadius.Card.Dto.CardCreateDto;
import com.cd.Arcadius.Card.Dto.CardResponseDto;

@Service
public class CardMapper {
    public Card toEntity(CardCreateDto cardDto) {
        Card card = new Card();
        card.setName(cardDto.name());
        card.setFilename(cardDto.filename());
        card.setType(cardDto.type());
        card.setRarity(cardDto.rarity());

        return card;
    }

    public CardResponseDto toDto(Card card) {
        return new CardResponseDto(
                card.getId(), card.getName(), card.getFilename(), card.getType(), card.getRarity());
    }
}
