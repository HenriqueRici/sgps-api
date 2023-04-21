package br.com.henrique.sgps.repository;

import br.com.henrique.sgps.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
    @Query("""
            select p from Perfil p where p.nome = 'PARTICIPANTE'
            """)
    Optional<Perfil> findPerfilParticipante();

    @Query("""
            select p from Perfil p where p.nome = 'ADMINISTRADOR'
            """)
    Optional<Perfil> findPerfilAdministrador();
}
