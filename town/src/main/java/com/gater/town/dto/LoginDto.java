package com.gater.town.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginDto {
    @NotNull
    private String id;

    @NotNull
    private String password;

    public boolean isSame(LoginDto loginDto) {
        return (id.equals(loginDto.getId())) && (password.equals(loginDto.getPassword()));
    }
}
