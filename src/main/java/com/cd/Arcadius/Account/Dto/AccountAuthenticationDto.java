package com.cd.Arcadius.Account.Dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.*;

public record AccountAuthenticationDto(
                @NotNull @NotEmpty @Email String email,
                @NotNull @NotEmpty @Length(min = 8) String password) {
}
