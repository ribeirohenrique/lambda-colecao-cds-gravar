package com.cds.colecao.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cd {

    private String id;
    private String titulo;
    private String artista;
    private int anoLancamento;
    private String genero;
}