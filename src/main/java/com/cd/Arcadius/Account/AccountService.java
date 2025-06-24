package com.cd.Arcadius.Account;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cd.Arcadius.Account.Dto.AccountAuthenticationDto;
import com.cd.Arcadius.Account.Dto.AccountCreateDto;
import com.cd.Arcadius.Account.Dto.AccountResponseAuthenticationDto;
import com.cd.Arcadius.Account.Dto.AccountResponseCreateDto;
import com.cd.Arcadius.User.User;
import com.cd.Arcadius.User.UserMapper;
import com.cd.Arcadius.User.UserService;

import jakarta.transaction.Transactional;

@Service
public class AccountService {

    private final UserMapper userMapper;
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper,
            PasswordEncoder passwordEncoder, UserService userService, UserMapper userMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Transactional
    public AccountResponseCreateDto createAccount(AccountCreateDto accountDto) {
        Account account = accountMapper.createDtoToAccount(accountDto);
        account.setPassword(passwordEncoder.encode(account.getPassword()));

        // Manage user creation
        User user = userService.createUser(accountDto.username());
        account.setUser(user);

        Account savedAccount = accountRepository.save(account);

        return accountMapper.accountToRespCreateDto(savedAccount);
    }

    public AccountResponseAuthenticationDto authenticateAccount(AccountAuthenticationDto accountDto) {
        Account account = accountRepository.findByEmail(accountDto.email());

        if (passwordEncoder.matches(accountDto.password(), account.getPassword())) {
            return new AccountResponseAuthenticationDto("", "", account.getEmail(),
                    userMapper.toDto(account.getUser()));
        }

        return null;
    }
}
