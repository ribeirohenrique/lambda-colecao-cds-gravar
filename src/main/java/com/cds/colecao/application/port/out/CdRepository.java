package com.cds.colecao.application.port.out;

import com.cds.colecao.domain.model.Cd;

public interface CdRepository {

    void salvar(Cd cd);

}