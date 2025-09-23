package com.cds.colecao.application;

import com.cds.colecao.domain.model.CD;
import com.cds.colecao.domain.port.in.GravarCDUseCase;
import com.cds.colecao.domain.port.out.CDRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class GravarCDService implements GravarCDUseCase {

    private final CDRepositoryPort cdRepository;

    public GravarCDService(CDRepositoryPort cdRepository) {
        this.cdRepository = cdRepository;
    }

    @Override
    public CD gravar(CD cd) {
        // Aqui poderiam entrar regras de negócio complexas.
        // Por exemplo: validar se o ano de lançamento é válido.
        if (cd.getAnoLancamento() < 1900) {
            throw new IllegalArgumentException("Ano de lançamento inválido.");
        }
        return cdRepository.save(cd);
    }
}