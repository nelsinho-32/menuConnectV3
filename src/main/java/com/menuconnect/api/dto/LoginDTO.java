package com.menuconnect.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {

    @NotBlank(message = "O e-mail não pode estar vazio")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @NotBlank(message = "A senha não pode estar vazia")
    private String senha;
}