package com.cd.Arcadius.User;

import org.springframework.stereotype.Service;

import com.cd.Arcadius.User.Dto.UserResponseDto;

@Service
public class UserMapper {
    public UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(), user.getUsername(), user.getLevel(), user.getLevelXp(),
                user.getTotalXp());
    }
}
