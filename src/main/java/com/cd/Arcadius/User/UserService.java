package com.cd.Arcadius.User;

import org.springframework.stereotype.Service;
import com.cd.Arcadius.User.Dto.UserResponseDto;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User createUser(String username) {
        User user = new User(username, 1, 0, 0L);
        return userRepository.save(user);
    }

    public UserResponseDto getUser(String username) {
        if (username != null) {
            User user = userRepository.findOneByUsername(username);

            if (user != null)
                return userMapper.toDto(user);

            return new UserResponseDto(0L, null, null, null, null);
        }

        return new UserResponseDto(0L, null, null, null, null);
    }
}
