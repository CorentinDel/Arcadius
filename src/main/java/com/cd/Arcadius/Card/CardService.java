package com.cd.Arcadius.Card;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cd.Arcadius.Card.Dto.CardCreateDto;
import com.cd.Arcadius.Card.Dto.CardResponseDto;

@Service
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardService(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    public CardResponseDto createCard(CardCreateDto cardDto) {
        Card card = cardMapper.toEntity(cardDto);
        card = cardRepository.save(card);
        return cardMapper.toDto(card);
    }

    public CardResponseDto updateCard(Long id, CardCreateDto cardDto) {
        Card card = cardMapper.toEntity(cardDto);
        card.setId(id);
        card = cardRepository.save(card);
        return cardMapper.toDto(card);
    }

    public CardResponseDto getCard(Long id) {
        Optional<Card> card = cardRepository.findById(id);

        if (card.isPresent())
            return cardMapper.toDto(card.get());

        return new CardResponseDto(0L, null, null, null, null);
    }

    public List<CardResponseDto> getCards() {
        List<Card> cards = cardRepository.findAll();

        return cards.stream().map(cardMapper::toDto).toList();
    }
}
