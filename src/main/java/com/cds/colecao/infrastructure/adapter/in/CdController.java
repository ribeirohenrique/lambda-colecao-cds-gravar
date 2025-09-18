package com.cds.colecao.infrastructure.adapter.in;

import com.cds.colecao.application.port.in.CadastrarCdUseCase;
import com.cds.colecao.domain.model.Cd;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cds")
public class CdController {

    private final CadastrarCdUseCase cadastrarCdUseCase;

    public CdController(CadastrarCdUseCase cadastrarCdUseCase) {
        this.cadastrarCdUseCase = cadastrarCdUseCase;
    }

    @PostMapping
    public ResponseEntity<String> cadastrarCd(@RequestBody Cd cd) {
        try {
            cadastrarCdUseCase.cadastrar(cd);
            return ResponseEntity.status(HttpStatus.CREATED).body("CD cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar CD: " + e.getMessage());
        }
    }
}