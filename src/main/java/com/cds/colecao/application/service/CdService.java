package com.cds.colecao.application.service;

import com.cds.colecao.application.port.in.CadastrarCdUseCase;
import com.cds.colecao.application.port.out.CdRepository;
import com.cds.colecao.domain.model.Cd;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CdService implements CadastrarCdUseCase {

    private final CdRepository cdRepository;

    public CdService(CdRepository cdRepository) {
        this.cdRepository = cdRepository;
    }

    @Override
    public void cadastrar(Cd cd) {
        // Lógica para garantir a idempotência
        if (cd.getId() == null || cd.getId().isEmpty()) {
            cd.setId(UUID.randomUUID().toString());
        }

        // Delega a responsabilidade de salvar para o repositório
        cdRepository.salvar(cd);
    }
}