package br.com.henrique.sgps.dtos.seletivo;

import br.com.henrique.sgps.domain.Inscricao;
import br.com.henrique.sgps.domain.Participante;
import br.com.henrique.sgps.domain.enuns.Classe;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.Objects;

@Value
@Builder
public class FindAllParticipanteDetailByEditalResponse {

    Integer id;
    String nome;
    String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataNascimento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataIngresso;
    Classe classe;
    String nivel;
    String situacaoInscricao;

    public static FindAllParticipanteDetailByEditalResponse of(Inscricao inscricao){
        Participante participante = Objects.requireNonNull(inscricao.getParticipante());
        return FindAllParticipanteDetailByEditalResponse.builder()
                .id(participante.getId())
                .nome(participante.getNome())
                .cpf(participante.getCpf())
                .dataNascimento(participante.getDataNascimento())
                .dataIngresso(participante.getDataIngresso())
                .classe(participante.getClasse())
                .nivel(participante.getNivel().getDescricao())
                .situacaoInscricao(inscricao.getSituacaoInscricao().getDescricao())
                .build();
    }


}
