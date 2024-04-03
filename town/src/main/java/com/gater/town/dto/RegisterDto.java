package com.gater.town.dto;

import com.gater.town.domain.Region;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    @NotNull
    private String id;
    @NotNull
    private String password;
    @NotNull
    private String username;
    @NotNull
    private Region region;
}
