package com.cd.Arcadius.Account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AccountConfiguration {
    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
