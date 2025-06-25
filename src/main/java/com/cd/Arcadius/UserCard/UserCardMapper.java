package com.cd.Arcadius.UserCard;

import org.springframework.stereotype.Service;

import com.cd.Arcadius.UserCard.Dto.UserCardDto;

@Service
public class UserCardMapper {
    public UserCardDto toDto(UserCard userCard) {
        return new UserCardDto(userCard.getId().getUserId(), userCard.getId().getCardId(), userCard.getCount());
    }
}
