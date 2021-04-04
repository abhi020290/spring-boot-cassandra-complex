package com.springbootcassandra.springbootcassandra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;

import java.util.Collections;
import java.util.List;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    private static final String KEYSPACE= "product_keyspace";
    private static final String BASE_PACKAGE= "com.springbootcassandra.springbootcassandra.entity";
    @Override
    public String[] getEntityBasePackages() {
        return new String[]{BASE_PACKAGE};
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }

    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        DropKeyspaceSpecification dropKeyspaceSpecification = DropKeyspaceSpecification.dropKeyspace(KEYSPACE);
        return Collections.singletonList(dropKeyspaceSpecification);
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification createKeyspaceSpecification = CreateKeyspaceSpecification.
                createKeyspace(KEYSPACE).with(KeyspaceOption.DURABLE_WRITES, true);
        return Collections.singletonList(createKeyspaceSpecification);
    }

}
