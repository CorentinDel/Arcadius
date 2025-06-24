package com.cd.Arcadius.Account;

import org.springframework.stereotype.Service;

import com.cd.Arcadius.Account.Dto.AccountAuthenticationDto;
import com.cd.Arcadius.Account.Dto.AccountCreateDto;
import com.cd.Arcadius.Account.Dto.AccountResponseCreateDto;
import com.cd.Arcadius.User.UserMapper;

@Service
public class AccountMapper {
    private final UserMapper userMapper;

    public AccountMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Account createDtoToAccount(AccountCreateDto dto) {
        Account account = new Account();
        account.setEmail(dto.email());
        account.setPassword(dto.password());

        return account;
    }

    public Account authenticationDtoToAccount(AccountAuthenticationDto dto) {
        Account account = new Account();
        account.setEmail(dto.email());
        account.setPassword(dto.password());

        return account;
    }

    public AccountResponseCreateDto accountToRespCreateDto(Account account) {
        return new AccountResponseCreateDto(account.getEmail(), account.getCreatedAt(),
                userMapper.toDto(account.getUser()));
    }
}
