package com.cd.Arcadius.Account.Dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.*;

public record AccountCreateDto(
                @NotEmpty @Email String email,
                @NotEmpty @Length(min = 4) String password,
                @NotEmpty @Length(min = 6) String username) {
}
