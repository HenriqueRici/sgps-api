package br.com.henrique.sgps.service.participante;

import br.com.henrique.sgps.domain.Participante;
import br.com.henrique.sgps.dtos.participante.FindAllParticipanteDetailResponse;
import br.com.henrique.sgps.repository.ParticipanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllParticipanteDetail {
    @Autowired
    private final FindAllParticipante findAllParticipante;

    public List<FindAllParticipanteDetailResponse> execute(){
        return this.findAllParticipante.execute().stream()
                .map(FindAllParticipanteDetailResponse::of)
                .toList();
    }

}
