package com.mss1569.clicker.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPostRegister {
    @NotEmpty(message = "Name não pode ser vazio!")
    private String username;
    @NotEmpty(message = "Name não pode ser vazio!")
    private String password;
}
