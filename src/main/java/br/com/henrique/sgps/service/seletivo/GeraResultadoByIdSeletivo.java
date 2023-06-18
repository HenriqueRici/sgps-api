package br.com.henrique.sgps.service.seletivo;

import br.com.henrique.sgps.domain.Participante;
import br.com.henrique.sgps.dtos.seletivo.ResultadoByEdital;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class GeraResultadoByIdSeletivo {

    private final FindAllParticipanteByEdital findAllParticipanteByEdital;
    public List<ResultadoByEdital> execute(Integer idSeletivo){
        List<Participante> participantes = findParticipantesBySeletivo(idSeletivo);

        return participantes.stream()
              .sorted(Comparator.comparing(Participante::getPontos).reversed()
                      .thenComparing(Comparator.comparing(Participante::getDataIngresso)
                              .thenComparing(Participante::getDataNascimento)))
              .map(ResultadoByEdital::of)
              .toList();
    }


    private List<Participante> findParticipantesBySeletivo(Integer idSeletivo){
        return  findAllParticipanteByEdital.execute(idSeletivo);
    }

}
