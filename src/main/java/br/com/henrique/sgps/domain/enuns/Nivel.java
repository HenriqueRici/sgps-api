package br.com.henrique.sgps.domain.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Nivel {
    N001(1, "1"),
    N002(2, "2"),
    N003(3, "3"),
    N004(4, "4"),
    N005(5, "5"),
    N006(6, "6"),
    N007(7, "7"),
    N008(8, "8"),
    N009(9, "9"),
    N010(10, "10"),
    N011(11, "11"),
    N012(12, "12");

    private final Integer peso;
    private final String descricao;
}
