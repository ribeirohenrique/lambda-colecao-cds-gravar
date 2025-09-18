package com.cds.colecao.infrastructure.adapter.out;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.cds.colecao.application.port.out.CdRepository;
import com.cds.colecao.domain.model.Cd;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DynamoDbRepository implements CdRepository {

    private final AmazonDynamoDB amazonDynamoDB;
    private final String tableName = "ColecaoDeCDs";

    public DynamoDbRepository(AmazonDynamoDB amazonDynamoDB) {
        this.amazonDynamoDB = amazonDynamoDB;
    }

    @Override
    public void salvar(Cd cd) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("id", new AttributeValue(cd.getId()));
        item.put("titulo", new AttributeValue(cd.getTitulo()));
        item.put("artista", new AttributeValue(cd.getArtista()));
        item.put("anoLancamento", new AttributeValue().withN(String.valueOf(cd.getAnoLancamento())));
        item.put("genero", new AttributeValue(cd.getGenero()));

        PutItemRequest request = new PutItemRequest()
                .withTableName(tableName)
                .withItem(item);

        amazonDynamoDB.putItem(request);
    }
}