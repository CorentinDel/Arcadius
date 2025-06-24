package com.cd.Arcadius.Card;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.Arcadius.Card.Dto.CardCreateDto;
import com.cd.Arcadius.Card.Dto.CardResponseDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public CardResponseDto createCard(@RequestBody CardCreateDto cardDto) {
        return cardService.createCard(cardDto);
    }

    @GetMapping
    public List<CardResponseDto> getCards() {
        return cardService.getCards();
    }

    @PutMapping("/{id}")
    public CardResponseDto updateCard(@PathVariable Long id, @RequestBody CardCreateDto cardDto) {
        return cardService.updateCard(id, cardDto);
    }

    @GetMapping("/{id}")
    public CardResponseDto getCardById(@PathVariable Long id) {
        return cardService.getCard(id);
    }
}
