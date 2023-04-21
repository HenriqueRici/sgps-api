package br.com.henrique.sgps.service;

import br.com.henrique.sgps.domain.Participante;
import br.com.henrique.sgps.domain.Usuario;
import br.com.henrique.sgps.dtos.CreateParticipanteRequest;
import br.com.henrique.sgps.dtos.ParticipanteDetail;
import br.com.henrique.sgps.repository.ParticipanteRepository;
import br.com.henrique.sgps.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParticipanteService {
    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;
    private final ParticipanteRepository participanteRepository;

    public ParticipanteDetail create(CreateParticipanteRequest request) {
        Participante participante = new Participante();

        participante.setNome(request.getNome());
        participante.setCpf(request.getCpf());
        participante.setDataNascimento(request.getDataNascimento());
        participante.setDataIngresso(request.getDataIngresso());
        participante.setClasse(request.getClasse());
        participante.setNivel(request.getNivel());
        Usuario usuario = usuarioService.createParticipante(new CreateUsuarioParticipanteRequest(request.getCpf(), request.getSenha()));
        participante.setUsuario(usuario);
        participanteRepository.save(participante);
        return null;
    }

}
