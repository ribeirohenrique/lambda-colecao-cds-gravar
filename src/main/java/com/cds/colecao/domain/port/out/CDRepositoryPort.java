package com.cds.colecao.domain.port.out;


import com.cds.colecao.domain.model.CD;

public interface CDRepositoryPort {
    CD save(CD cd);
}