package com.cd.Arcadius.UserCard;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cd.Arcadius.Card.Card;
import com.cd.Arcadius.Card.CardRepository;
import com.cd.Arcadius.User.User;
import com.cd.Arcadius.User.UserRepository;

@Service
public class UserCardService {
    private UserRepository userRepository;
    private CardRepository cardRepository;
    private UserCardRepository userCardRepository;

    public UserCardService(UserRepository userRepository, CardRepository cardRepository,
            UserCardRepository userCardRepository) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.userCardRepository = userCardRepository;
    }

    public void addCardToUser(Long userId, Long cardId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Card card = cardRepository.findById(cardId).orElseThrow(() -> new RuntimeException("Card not found"));

        UserCardKey userCardKey = new UserCardKey();
        userCardKey.setUserId(userId);
        userCardKey.setCardId(cardId);

        Optional<UserCard> userCard = getUserCardById(userCardKey);

        if (userCard.isPresent())
            updateUserCardCount(userCard.get());
        else {
            UserCard newUserCard = new UserCard();
            newUserCard.setId(userCardKey);
            newUserCard.setCount(1);
            newUserCard.setUser(user);
            newUserCard.setCard(card);

            userCardRepository.save(newUserCard);
        }
    }

    private Optional<UserCard> getUserCardById(UserCardKey userCardKey) {
        return userCardRepository.findById(userCardKey);
    }

    public List<UserCard> getCardsForUser(Long userId) {
        return userCardRepository.findByUserId(userId);
    }

    private UserCard updateUserCardCount(UserCard userCard) {
        userCard.setCount(userCard.getCount() + 1);

        return userCardRepository.save(userCard);
    }
}
