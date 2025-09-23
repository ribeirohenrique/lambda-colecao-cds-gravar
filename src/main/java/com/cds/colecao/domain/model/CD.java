package com.cds.colecao.domain.model;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.UUID;

@Data
@DynamoDbBean
public class CD {
    private String id;
    private String titulo;
    private String artista;
    private Integer anoLancamento;
    private String genero;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    // Construtor para gerar ID automaticamente
    public CD() {
        this.id = UUID.randomUUID().toString();
    }
}