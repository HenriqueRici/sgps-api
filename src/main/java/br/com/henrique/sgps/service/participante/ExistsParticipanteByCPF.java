package br.com.henrique.sgps.service.participante;

import br.com.henrique.sgps.repository.ParticipanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExistsParticipanteByCPF {

    @Autowired
    private final ParticipanteRepository repository;

    public boolean execute(String cpf){
        return this.repository.existsParticipanteByCpf(cpf);
    }

}