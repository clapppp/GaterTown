package com.gater.town.dto;

import com.gater.town.domain.Region;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RegisterDto {
    @NotBlank
    private String id;
    @NotBlank
    private String password;
    @NotBlank
    private String username;
    @NotNull
    private Region region;
}
