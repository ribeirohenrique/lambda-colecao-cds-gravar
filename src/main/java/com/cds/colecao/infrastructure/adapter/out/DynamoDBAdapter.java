package com.cds.colecao.infrastructure.adapter.out;

import com.cds.colecao.domain.model.CD;
import com.cds.colecao.domain.port.out.CDRepositoryPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class DynamoDBAdapter implements CDRepositoryPort {

    private final DynamoDbTable<CD> cdTable;

    public DynamoDBAdapter(DynamoDbEnhancedClient enhancedClient, @Value("${dynamodb.table.name}") String tableName) {
        this.cdTable = enhancedClient.table(tableName, TableSchema.fromBean(CD.class));
    }

    @Override
    public CD save(CD cd) {
        cdTable.putItem(cd);
        return cd;
    }
}