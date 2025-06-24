package com.cd.Arcadius.Account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.Arcadius.Account.Dto.AccountAuthenticationDto;
import com.cd.Arcadius.Account.Dto.AccountCreateDto;
import com.cd.Arcadius.Account.Dto.AccountResponseAuthenticationDto;
import com.cd.Arcadius.Account.Dto.AccountResponseCreateDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/auth")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public AccountResponseCreateDto createAccount(@RequestBody AccountCreateDto accountDto) {
        return accountService.createAccount(accountDto);
    }

    @PostMapping("/login")
    public AccountResponseAuthenticationDto authenticateAccount(@RequestBody AccountAuthenticationDto accountDto) {
        return accountService.authenticateAccount(accountDto);
    }
}