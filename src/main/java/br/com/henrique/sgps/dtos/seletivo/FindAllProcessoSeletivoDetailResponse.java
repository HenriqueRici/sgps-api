package br.com.henrique.sgps.dtos.seletivo;

import br.com.henrique.sgps.domain.ProcessoSeletivo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class FindAllProcessoSeletivoDetailResponse {
    Integer id;
    String edital;
    String cargo;
    Integer anoReferencia;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime dataInicioInscricoes;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime dataFimInscricoes;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime dataInicioRetificacao;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime dataFimRetificacao;


    public static FindAllProcessoSeletivoDetailResponse of(ProcessoSeletivo processoSeletivo) {
        return new FindAllProcessoSeletivoDetailResponse(
                processoSeletivo.getId(),
                processoSeletivo.getEdital(),
                processoSeletivo.getCargo(),
                processoSeletivo.getAnoReferencia(),
                processoSeletivo.getDataInicioInscricoes(),
                processoSeletivo.getDataFimInscricoes(),
                processoSeletivo.getDataInicioRetificacao(),
                processoSeletivo.getDataFimRetificacao()
        );
    }
}