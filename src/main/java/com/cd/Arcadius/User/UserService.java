package com.cd.Arcadius.User;

import org.springframework.stereotype.Service;
import com.cd.Arcadius.Pack.PackService;
import com.cd.Arcadius.User.Dto.UserResponseDto;

@Service
public class UserService {

    private final PackService packService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, PackService packService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.packService = packService;
    }

    public User createUser(String username) {
        User user = new User(username, 1, 0, 0L);
        user.setPack(packService.createPack());
        return userRepository.save(user);
    }

    public UserResponseDto getUser(String username) {
        if (username != null) {
            User user = userRepository.findOneByUsername(username);

            if (user != null)
                return userMapper.toDto(user);

            return new UserResponseDto(0L, null, null, null, null, null);
        }

        return new UserResponseDto(0L, null, null, null, null, null);
    }
}
