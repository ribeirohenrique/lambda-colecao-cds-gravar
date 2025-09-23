package com.cds.colecao.domain.port.in;

import com.cds.colecao.domain.model.CD;

public interface GravarCDUseCase {
    CD gravar(CD cd);
}