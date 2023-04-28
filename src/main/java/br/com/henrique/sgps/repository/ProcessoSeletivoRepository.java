package br.com.henrique.sgps.repository;

import br.com.henrique.sgps.domain.ProcessoSeletivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProcessoSeletivoRepository extends JpaRepository<ProcessoSeletivo, Integer> {

    @Query("SELECT obj FROM ProcessoSeletivo obj WHERE obj.edital =:edital")
    Optional<ProcessoSeletivo> findByEdital(@Param("edital") String edital);

    boolean existsProcessoSeletivoByEdital(String edital);


}
