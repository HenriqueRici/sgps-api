package br.com.henrique.sgps.service.participante;

import br.com.henrique.sgps.domain.Inscricao;
import br.com.henrique.sgps.domain.enuns.SituacaoInscricao;
import br.com.henrique.sgps.dtos.participante.CreateInscricaoRequest;
import br.com.henrique.sgps.dtos.participante.CreateInscricaoResponse;
import br.com.henrique.sgps.dtos.participante.CreateParticipanteRequest;
import br.com.henrique.sgps.exceptions.DataIntegratyViolationException;
import br.com.henrique.sgps.repository.InscricaoRepository;
import br.com.henrique.sgps.repository.ProcessoSeletivoRepository;
import br.com.henrique.sgps.service.seletivo.FindProcessoSeletivoById;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CreateInscricaoParticipante {

    private final ExistsParticipanteByCPF existsParticipanteByCPF;
    private final FindParticipanteByCPF findParticipanteByCPF;
    private final FindProcessoSeletivoById findProcessoSeletivoById;
    private final InscricaoRepository inscricaoRepository;
    private final ProcessoSeletivoRepository processoSeletivoRepository;

    public CreateInscricaoResponse execute(@Valid CreateInscricaoRequest request) {

        if (!existsParticipanteByCPF.execute(request.getCpf()))
            throw new DataIntegratyViolationException("O CPF não consta na base de dados!");

        checkPeridoInscricoes(request.getIdProcessoSeletivo());

        var inscricao = Inscricao.builder()
                .participante(findParticipanteByCPF.execute(request.getCpf()))
                .processoSeletivo(findProcessoSeletivoById.execute(request.getIdProcessoSeletivo()))
                .dataInscricao(LocalDateTime.now())
                .situacaoInscricao(SituacaoInscricao.EM_ANALISE)
                .build();
        Inscricao savedInscricao = inscricaoRepository.save(inscricao);
        return CreateInscricaoResponse.of(savedInscricao);
    }

    private void checkPeridoInscricoes(Integer idSeletivo){
        FindProcessoSeletivoById buscaSeletivo = new FindProcessoSeletivoById(processoSeletivoRepository);
        var processoSeletivo = buscaSeletivo.execute(idSeletivo);
        if (LocalDateTime.now().isAfter(processoSeletivo.getDataInicioInscricoes()) && LocalDateTime.now().isBefore(processoSeletivo.getDataFimInscricoes())) return;
        throw new DataIntegratyViolationException("Fora do periodo de inscrições!");
    }
}
