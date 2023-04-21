package br.com.henrique.sgps.domain.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Classe {
    A(100),
    B(200),
    C(300),
    D(400),
    E(500);

    private final Integer peso;
}
