package com.cd.Arcadius.Pack;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PackDto(Long id, int amount, @JsonProperty("next_at") Date nextAt) {

}
