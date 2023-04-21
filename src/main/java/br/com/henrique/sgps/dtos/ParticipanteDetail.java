package br.com.henrique.sgps.dtos;

import br.com.henrique.sgps.domain.enuns.Classe;
import br.com.henrique.sgps.domain.enuns.Nivel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ParticipanteDetail {
   private final Integer id;
    private final String nome;
    private final String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate dataNascimento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate dataIngresso;
    private final Classe classe;
    private final Nivel nivel;
    private final String login;
}
