package com.mss1569.clicker.DTO;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class UserPostRequest {
    @NotEmpty(message = "Name não pode ser vazio!")
    private String username;
    @NotEmpty(message = "Name não pode ser vazio!")
    private String password;
}
