package com.cd.Arcadius.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cd.Arcadius.User.Dto.UserCardAddDto;
import com.cd.Arcadius.User.Dto.UserResponseDto;
import com.cd.Arcadius.UserCard.UserCardService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserCardService userCardService;

    public UserController(UserService userService, UserCardService userCardService) {
        this.userService = userService;
        this.userCardService = userCardService;
    }

    @GetMapping()
    public UserResponseDto getUser(@RequestParam String username) {
        return userService.getUser(username);
    }

    @PutMapping("/cards")
    @ResponseStatus(code = HttpStatus.OK)
    public void putMethodName(@RequestBody UserCardAddDto userCardKey) {
        userCardService.addCardToUser(userCardKey.userId(), userCardKey.cardId());
    }
}
