package br.com.henrique.sgps.repository;

import br.com.henrique.sgps.domain.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {

    @Query("SELECT obj FROM Participante obj WHERE obj.cpf = :cpf")
    Optional<Participante> findByCPF(@Param("cpf") String cpf);

    boolean existsParticipanteByCpf(String cpf);
}
