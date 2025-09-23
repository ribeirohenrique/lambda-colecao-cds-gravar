package com.cds.colecao.infrastructure.adapter.in;

import com.cds.colecao.domain.model.CD;
import com.cds.colecao.domain.port.in.GravarCDUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class LambdaHandler {

    private final GravarCDUseCase gravarCDUseCase;

    public LambdaHandler(GravarCDUseCase gravarCDUseCase) {
        this.gravarCDUseCase = gravarCDUseCase;
    }

    @Bean
    public Function<CD, CD> gravarCD() {
        return cd -> gravarCDUseCase.gravar(cd);
    }
}