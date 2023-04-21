package br.com.henrique.sgps.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateUsuarioParticipanteRequest {
    private final String login;
    private final String senha;
}
