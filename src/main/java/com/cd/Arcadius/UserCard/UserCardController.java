package com.cd.Arcadius.UserCard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cd.Arcadius.User.Dto.UserCardAddDto;
import com.cd.Arcadius.UserCard.Dto.UserCardDto;

@RestController
@RequestMapping("/api/v1/users")
public class UserCardController {
    private final UserCardService userCardService;

    public UserCardController(UserCardService userCardService) {
        this.userCardService = userCardService;
    }

    @PutMapping("/cards")
    @ResponseStatus(code = HttpStatus.OK)
    public void addCardToUser(@RequestBody UserCardAddDto userCardKey) {
        userCardService.addCardToUser(userCardKey.userId(), userCardKey.cardId());
    }

    @GetMapping("{userId}/cards")
    public List<UserCardDto> getUserCardsByUserId(@PathVariable Long userId) {
        return userCardService.getCardsByUserId(userId);
    }
}
