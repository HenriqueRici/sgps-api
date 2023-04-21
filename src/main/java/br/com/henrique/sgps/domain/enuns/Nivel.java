package br.com.henrique.sgps.domain.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Nivel {
    N001(1, "001"),
    N002(2, "002"),
    N003(3, "003"),
    N004(4, "004"),
    N005(5, "005"),
    N006(6, "006"),
    N007(7, "007"),
    N008(8, "008"),
    N009(9, "009"),
    N010(10, "010"),
    N011(11, "011"),
    N012(12, "012");

    private final Integer peso;
    private final String descricao;
}
