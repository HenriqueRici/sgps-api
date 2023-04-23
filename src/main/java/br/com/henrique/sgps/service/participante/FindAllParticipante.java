package br.com.henrique.sgps.service.participante;

import br.com.henrique.sgps.domain.Participante;
import br.com.henrique.sgps.repository.ParticipanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllParticipante {
    @Autowired
    private final ParticipanteRepository repository;

    public List<Participante> execute(){
        return this.repository.findAll();
    }

}
