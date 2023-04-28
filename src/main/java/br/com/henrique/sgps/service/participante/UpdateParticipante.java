package br.com.henrique.sgps.service.participante;

import br.com.henrique.sgps.domain.Participante;
import br.com.henrique.sgps.domain.Usuario;
import br.com.henrique.sgps.dtos.participante.UpdateParticipanteRequest;
import br.com.henrique.sgps.dtos.participante.UpdateParticipanteResponse;
import br.com.henrique.sgps.repository.ParticipanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class UpdateParticipante {


    private final ParticipanteRepository participanteRepository;

    private final FindParticipanteById findParticipanteById;

    public UpdateParticipanteResponse execute(Integer id, UpdateParticipanteRequest request) {

        Participante participante = this.findParticipanteById.execute(id);

        maybeUpdate(request::getNome, participante::setNome);
        maybeUpdate(request::getDataNascimento, participante::setDataNascimento);
        maybeUpdate(request::getDataIngresso, participante::setDataIngresso);
        maybeUpdate(request::getClasse, participante::setClasse);
        maybeUpdate(request::getNivel, participante::setNivel);
        maybeUpdateUsuario(participante, request);
        Participante savedParticipante = participanteRepository.save(participante);
        return UpdateParticipanteResponse.of(savedParticipante);
    }

    private <T> void maybeUpdate(Supplier<T> supplier, Consumer<T> consumer) {
        T supplierValue = supplier.get();
        if (Objects.isNull(supplierValue)) return;
        consumer.accept(supplierValue);
    }

    private void maybeUpdateUsuario(Participante participante, UpdateParticipanteRequest request) {
        Usuario usuario = participante.getUsuario();
        maybeUpdate(request::getSenha, usuario::setSenha);
        participante.setUsuario(usuario);
    }

}
