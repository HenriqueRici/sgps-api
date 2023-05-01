package br.com.henrique.sgps.service.participante;

import br.com.henrique.sgps.domain.Participante;
import br.com.henrique.sgps.domain.Usuario;
import br.com.henrique.sgps.dtos.CreateUsuarioParticipanteRequest;
import br.com.henrique.sgps.dtos.participante.CreateParticipanteRequest;
import br.com.henrique.sgps.dtos.participante.CreateParticipanteResponse;
import br.com.henrique.sgps.exceptions.DataIntegratyViolationException;
import br.com.henrique.sgps.repository.ParticipanteRepository;
import br.com.henrique.sgps.service.inscricao.CreateInscricao;
import br.com.henrique.sgps.service.usuario.CreateUsuario;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateParticipante {


    private final CreateUsuario createUsuario;

    private final ParticipanteRepository participanteRepository;

    private final ExistsParticipanteByCPF existsParticipanteByCPF;

    private final CreateInscricao createInscricao;

    public CreateParticipanteResponse execute(@Valid CreateParticipanteRequest request) {
        checkIfCpfIsTheSame(request);
        checkIfSenhaIsTheSame(request);

        Usuario usuario = createUsuario.execute(CreateUsuarioParticipanteRequest.of(request));

        var participante = Participante.builder()
                .nome(request.getNome())
                .cpf(request.getCpf())
                .dataNascimento(request.getDataNascimento())
                .dataIngresso(request.getDataIngresso())
                .classe(request.getClasse())
                .nivel(request.getNivel())
                .usuario(usuario)
                .build();
        Participante savedParticipante = participanteRepository.save(participante);
        createInscricao.execute(request.getIdProcessoSeletivo(), savedParticipante);
        return CreateParticipanteResponse.of(savedParticipante);
    }


    private void checkIfCpfIsTheSame(CreateParticipanteRequest request) {
        if (request.getCpf().equals(request.getConfirmacaoCpf())) return;
        throw new DataIntegratyViolationException("O CPF e a confirmação do CPF não são iguais!");
    }

    private void checkIfSenhaIsTheSame(CreateParticipanteRequest request) {
        if (request.getSenha().equals(request.getConfirmacaoSenha())) return;
        throw new DataIntegratyViolationException("A senha e a confirmação da senha não são iguais!");
    }
}
