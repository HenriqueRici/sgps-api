package br.com.henrique.sgps.service;

import br.com.henrique.sgps.domain.Perfil;
import br.com.henrique.sgps.domain.Usuario;
import br.com.henrique.sgps.repository.PerfilRepository;
import br.com.henrique.sgps.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final PerfilRepository perfilRepository;
    private final UsuarioRepository usuarioRepository;

    public Usuario createParticipante(CreateUsuarioParticipanteRequest request) {
        Usuario usuario = new Usuario();
        usuario.setLogin(request.getLogin());
        usuario.setSenha(request.getSenha());
        usuario.setPerfil(findPerfilParticipante());
        return usuarioRepository.save(usuario);
    }

    private Perfil findPerfilParticipante(){
        return this.perfilRepository.findPerfilParticipante()
                .orElseThrow();
    }

}
