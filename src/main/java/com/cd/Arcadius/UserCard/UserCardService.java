package com.cd.Arcadius.UserCard;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cd.Arcadius.Card.Card;
import com.cd.Arcadius.Card.CardRepository;
import com.cd.Arcadius.User.User;
import com.cd.Arcadius.User.UserRepository;
import com.cd.Arcadius.UserCard.Dto.UserCardDto;

@Service
public class UserCardService {
    private UserRepository userRepository;
    private CardRepository cardRepository;
    private UserCardRepository userCardRepository;
    private UserCardMapper userCardMapper;

    public UserCardService(UserRepository userRepository, CardRepository cardRepository,
            UserCardRepository userCardRepository, UserCardMapper userCardMapper) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.userCardRepository = userCardRepository;
        this.userCardMapper = userCardMapper;
    }

    public UserCardDto addCardToUser(Long userId, Long cardId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Card card = cardRepository.findById(cardId).orElseThrow(() -> new RuntimeException("Card not found"));

        UserCardKey userCardKey = new UserCardKey();
        userCardKey.setUserId(userId);
        userCardKey.setCardId(cardId);

        Optional<UserCard> userCard = getUserCardById(userCardKey);

        if (userCard.isPresent())
            return userCardMapper.toDto(updateUserCardCount(userCard.get()));
        else {
            UserCard newUserCard = new UserCard();
            newUserCard.setId(userCardKey);
            newUserCard.setCount(1);
            newUserCard.setUser(user);
            newUserCard.setCard(card);

            return userCardMapper.toDto(userCardRepository.save(newUserCard));
        }
    }

    private Optional<UserCard> getUserCardById(UserCardKey userCardKey) {
        return userCardRepository.findById(userCardKey);
    }

    public List<UserCardDto> getCardsByUserId(Long userId) {
        return userCardRepository.findByUserId(userId).stream().map(userCardMapper::toDto).toList();
    }

    private UserCard updateUserCardCount(UserCard userCard) {
        userCard.setCount(userCard.getCount() + 1);

        return userCardRepository.save(userCard);
    }
}
