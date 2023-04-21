package br.com.henrique.sgps.dtos;
import br.com.henrique.sgps.domain.enuns.Classe;
import br.com.henrique.sgps.domain.enuns.Nivel;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
@Getter
public class CreateParticipanteRequest {



    @NotNull
    @NotBlank
    private final String nome;
    @NotNull
    @NotBlank
    @CPF
    private final String cpf;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate dataNascimento;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate dataIngresso;
    @NotNull
    private final Classe classe;
    @NotNull
    private final Nivel nivel;
    @NotNull
    @NotBlank
    private final String senha;


    @JsonCreator
    public CreateParticipanteRequest(String nome, String cpf, LocalDate dataNascimento, LocalDate dataIngresso, Classe classe, Nivel nivel, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataIngresso = dataIngresso;
        this.classe = classe;
        this.nivel = nivel;
        this.senha = senha;
    }
}
