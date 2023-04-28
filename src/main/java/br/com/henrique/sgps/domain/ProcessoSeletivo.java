package br.com.henrique.sgps.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class ProcessoSeletivo implements Serializable {

    @Serial
    private static final long serialVersionUID = -871773016390593732L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String edital;
    @Column
    private String cargo;
    @Column(name = "ano_referencia")
    private Integer anoReferencia;
    @Column(name = "dt_inicio_inscricoes")
    private LocalDateTime dataInicioInscricoes;
    @Column(name = "dt_fim_inscricoes")
    private LocalDateTime dataFimInscricoes;
    @Column(name = "dt_inicio_retificacao")
    private LocalDateTime dataInicioRetificacao;
    @Column(name = "dt_fim_retificacao")
    private LocalDateTime dataFimRetificacao;

}
