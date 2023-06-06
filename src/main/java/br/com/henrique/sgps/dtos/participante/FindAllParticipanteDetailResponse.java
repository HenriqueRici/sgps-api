package br.com.henrique.sgps.dtos.participante;
import br.com.henrique.sgps.domain.Participante;
import br.com.henrique.sgps.domain.enuns.Classe;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.time.LocalDate;


@Value
public class FindAllParticipanteDetailResponse {
    Integer id;
    String nome;
    String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataNascimento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataIngresso;
    Classe classe;
    String nivel;

    public static FindAllParticipanteDetailResponse of(Participante participante) {
        return new FindAllParticipanteDetailResponse(
                participante.getId(),
                participante.getNome(),
                participante.getCpf(),
                participante.getDataNascimento(),
                participante.getDataIngresso(),
                participante.getClasse(),
                participante.getNivel().getDescricao()

        );
    }
}
